
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("studentnumber: ");
            String studentNumber = scanner.nextLine();
            students.add(new Student(name, studentNumber));
        }
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.print("Give search term: ");
        String searchTerm = scanner.nextLine();
        System.out.println("Result:");
        for (Student student : students) {
            if (student.getName().contains(searchTerm)) {
                System.out.println(student);
            }
        }
    }
}