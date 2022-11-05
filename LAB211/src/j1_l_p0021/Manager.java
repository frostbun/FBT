package j1_l_p0021;

import java.util.List;

import utils.Reader;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    private final List<Student> studentList;
    private final Reader reader;

    public Manager(Reader reader) {
        studentList = new ArrayList<>();
        this.reader = reader;
    }

    public Student searchById(int id) {
        for(Student student: studentList) {
            if(student.getId() == id) return student;
        }
        return null;
    }

    public void create() {
        do for(int i=0; i<5; ++i) {
            int id = reader.getInteger("Input student id: ");
            if(searchById(id) != null) {
                System.out.println("Student id existed");
                continue;
            }
            String studentName = reader.getString("Input name: ");
            int age = reader.getInteger("Input age: ", 0, 200);
            int semester = reader.getInteger("Input semester: ", 1, 9);
            String courseName = reader.getString("Input course (each course separate by ,): ");
            studentList.add(new Student(id, studentName, age, semester, courseName));
            System.out.println("Student added");
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void findAndSort() {
        String studentName = reader.getString("Input name: ").toLowerCase();
        List<Student> found = new ArrayList<>();
        for(Student student: studentList) {
            if(student.getStudentName().toLowerCase().contains(studentName)) {
                found.add(student);
            }
        }
        Collections.sort(found, (s1,s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        for(Student student: found) {
            System.out.println(student);
        }
    }

    public void updateOrDelete() {
        int id = reader.getInteger("Input student id: ");
        Student student = searchById(id);
        if(student == null) {
            System.out.println("Student id not found");
            return;
        }
        System.out.println(student);
        if (reader.confirm("Update or Delete (U/D): : ", "u", "d")) {
            student.setStudentName(reader.getString("Input name: "));
            student.setAge(reader.getInteger("Input age: ", 0, 200));
            student.setSemester(reader.getInteger("Input semester: ", 1, 9));
            student.setCourseName(reader.getString("Input course (each course separate by ,): "));
            System.out.println("Student updated");
        }
        else {
            studentList.remove(student);
            System.out.println("Student deleted");
        }
    }

    public void report() {
        for(Student student: studentList) {
            System.out.format(
                "%-30s | %s | %d\n",
                student.getStudentName(),
                student.getCourseName(),
                student.getTotalCourses()
            );
        }
    }

    public static void main(String[] args) {
        String title = "\nWELCOME TO STUDENT MANAGEMENT";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("\t1. Create");
        menu.add("\t2. Find and Sort");
        menu.add("\t3. Update/Delete");
        menu.add("\t4. Report");
        menu.add("\t5. Exit");
        menu.add("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");

        try (Reader reader = new Reader()) {
            Manager manager = new Manager(reader);
            int choice;
            while((choice = reader.getChoice(title, menu, prompt, 1, 5)) != 5) {
                switch(choice) {
                    case 1:
                        manager.create();
                        break;
                    case 2:
                        manager.findAndSort();
                        break;
                    case 3:
                        manager.updateOrDelete();
                        break;
                    case 4:
                        manager.report();
                }
            }
        }
    }
}
