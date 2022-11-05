package j1_l_p0021;

public class Student {

    private final int id;
    private String studentName;
    private int age;
    private int semester;
    private String courseName;

    public Student(int id, String studentName, int age, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTotalCourses() {
        return courseName.split(",").length;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%-30s | %-3d | %-2d | %s", studentName, age, semester, courseName);
    }
}
