/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xTower, int xSound, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xTower.startsWith("B")) {
            return;
        }
        Node node = new Node(new Bell(xTower, xSound, xType));
        if (this.isEmpty()) {
            head = tail = node;
            return;
        }
        tail = tail.next = node;
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bell x, y;
        x = new Bell("X", 1, 2);
        y = new Bell("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node node2 = head.next;
        node2.next = new Node(x, node2.next);
        Node node4 = node2.next.next;
        node4.next = new Node(y, node4.next);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (head != tail) {
            Node walk = head;
            Node max = head;
            while (walk != tail) {
                if (walk.info.sound > max.info.sound) {
                    max = walk;
                }
                walk = walk.next;
            }
            max.next = max.next.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node n1 = head;
        Node n2 = n1.next;
        Node n3 = n2.next;
        Node n4 = n3.next;
        while (n4 != tail) {
            n1 = n2;
            n2 = n3;
            n3 = n4;
            n4 = n4.next;
        }
        // 1
        if (n2.info.sound > n1.info.sound) {
            Bell tmp = n2.info;
            n2.info = n1.info;
            n1.info = tmp;
        }
        if (n3.info.sound > n1.info.sound) {
            Bell tmp = n3.info;
            n3.info = n1.info;
            n1.info = tmp;
        }
        if (n4.info.sound > n1.info.sound) {
            Bell tmp = n4.info;
            n4.info = n1.info;
            n1.info = tmp;
        }
        // 2
        if (n3.info.sound > n2.info.sound) {
            Bell tmp = n3.info;
            n3.info = n2.info;
            n2.info = tmp;
        }
        if (n4.info.sound > n2.info.sound) {
            Bell tmp = n4.info;
            n4.info = n2.info;
            n2.info = tmp;
        }
        // 3
        if (n4.info.sound > n3.info.sound) {
            Bell tmp = n4.info;
            n4.info = n3.info;
            n3.info = tmp;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
