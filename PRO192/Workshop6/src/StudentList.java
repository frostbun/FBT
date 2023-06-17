import java.util.ArrayList;
import java.util.Comparator;

public class StudentList {
    
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    private int find(String code) {
        for(int i=0; i<students.size(); ++i) {
            if(students.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent() {
        String code = Input.inputPattern("Input code: ", "S[0-9]{3}");
        if(find(code) >= 0) {
            System.out.println("Code existed!");
            return;
        }
        students.add(new Student(code, Input.inputNonBlankStr("Input name: "), Input.inputInt("Input mark: ", 0, 10)));
        System.out.println("Ok!");
    }
    
    public void removeStudent() {
        String code = Input.inputPattern("Input code: ", "S[0-9]{3}");
        int index = find(code);
        if(index < 0) {
            System.out.println("Code not existed!");
            return;
        }
        students.remove(index);
        System.out.println("Ok!");
    }

    public void searchStudent() {
        String code = Input.inputPattern("Input code: ", "S[0-9]{3}");
        int index = find(code);
        if(index < 0) {
            System.out.println("Code not existed!");
            return;
        }
        System.out.println(students.get(index));
    }

    public void updateStudent() {
        String code = Input.inputPattern("Input code: ", "S[0-9]{3}");
        int index = find(code);
        if(index < 0) {
            System.out.println("Code not existed!");
            return;
        }
        students.get(index).setName(Input.inputNonBlankStr("Input name: "));
        students.get(index).setMark(Input.inputInt("Input mark: ", 0, 10));
        System.out.println("Ok!");
    }

    public void printAll() {
        System.out.format("%-10s%-20s%-10s\n", "Code", "Name", "Mark");
        students.sort(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getMark(), o1.getMark());
            }
        });
        for(Student s: students) {
            System.out.println(s);
        }
    }
}