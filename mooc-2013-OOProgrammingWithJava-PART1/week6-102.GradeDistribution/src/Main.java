import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program
        
        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        
        Grades grades = new Grades();
        while (true) {
            int grade = lukija.nextInt();
            if (grade == -1) {
                break;
            }
            grades.add(grade);
        }
        grades.printDistribution();
    }
}
