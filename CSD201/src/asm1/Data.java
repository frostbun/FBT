package asm1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Data implements Comparable<Data> {

    private final String phone;
    private Customer customer;
    private List<Call> callList;

    private Data(Customer customer) {
        this.phone = customer.getPhone();
        this.customer = customer;
        this.callList = new LinkedList<>();
    }

    private Data(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Call> getCallList() {
        return this.callList;
    }

    public void addCall(Call call) {
        this.callList.add(call);
    }

    public double getFee() {
        return this.callList.stream().collect(Collectors.summingDouble(Call::getFee));
    }

    public String getTypes() {
        int n = Call.VALID_TYPES.size();
        List<Integer> counts = new LinkedList<Integer>(Collections.nCopies(n, 0));
        this.callList.forEach(call -> {
            int index = Call.VALID_TYPES.indexOf(call.getType());
            counts.set(index, counts.get(index)+1);
        });
        String types = "";
        for (int i=0; i<n; ++i) {
            types += String.format("%s:%d ", Call.VALID_TYPES.get(i), counts.get(i));
        }
        return types;
    }

    public int compareTo(Data other) {
        return this.phone.compareTo(other.phone);
    }

    public static BinarySearchTree<Data> load(String customerFile, String callFile) {
        List<Customer> customerList = Customer.load(customerFile);
        List<Call> callList = Call.load(callFile);
        BinarySearchTree<Data> dataTree = new BinarySearchTree<>();
        customerList.forEach(customer -> dataTree.add(new Data(customer)));
        callList.forEach(call -> {
            Data data = dataTree.get(new Data(call.getPhone()));
            if (data != null) data.addCall(call);
        });
        return dataTree;
    }

    public static void save(BinarySearchTree<Data> dataTree, String file) {
        try (FileWriter writer = new FileWriter(file)) {
            double totalFee = 0;
            List<Call> totalCalls = new LinkedList<>();
            for (Data data: dataTree.getAll()) {
                double fee = data.getFee();
                writer.write(String.format("%s %.0f %s\n", data.getCustomer(), fee, data.getTypes()));
                totalFee += fee;
                totalCalls.addAll(data.getCallList());
            }
            writer.write("====================================================================================================\n");
            writer.write(String.format("Tổng tiền thu được: %.0f\n", totalFee));
            writer.write("====================================================================================================\n");
            Collections.sort(totalCalls, (c1, c2) -> {
                int i1 = Call.VALID_TYPES.indexOf(c1.getType());
                int i2 = Call.VALID_TYPES.indexOf(c2.getType());
                if (i1 == i2) return c1.getPhone().compareTo(c2.getPhone());
                return Integer.compare(i1, i2);
            });
            for (Call call: totalCalls) {
                writer.write(call + "\n");
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
