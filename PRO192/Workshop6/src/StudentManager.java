public class StudentManager {
    
    public static void main(String[] args) {
        String[] options = {"Add new student", "Search a student", "Update name and mark", "Remove a student", "List all student", "Quit"};
        StudentList students = new StudentList();
        while(true) {
            System.out.println("----------------------------------------");
            int choice = Input.getChoice(options);
            switch(choice) {
                case 1: students.addStudent(); break;
                case 2: students.searchStudent(); break;
                case 3: students.updateStudent(); break;
                case 4: students.removeStudent(); break;
                case 5: students.printAll(); break;
                case 6: return;
            }
        }
    }
}
