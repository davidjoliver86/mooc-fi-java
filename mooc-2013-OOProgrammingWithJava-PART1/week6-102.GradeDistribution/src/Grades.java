
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Grades {
    
    private ArrayList<Integer> grades;
    
    private static final int MAX_GRADE = 60;
    private static final int FIVE_STARS = 50;
    private static final int FOUR_STARS = 45;
    private static final int THREE_STARS = 40;
    private static final int TWO_STARS = 35;
    private static final int ONE_STAR = 30;
    private static final int FAILED = 0;
    
    private static final int NUMBER_OF_BUCKETS = 6;
    
    public Grades() {
        this.grades = new ArrayList<Integer>();
    }
    
    public void add(int grade) {
        if (grade >= FAILED && grade <= MAX_GRADE)
        this.grades.add(grade);
    }
    
    public void printDistribution() {
        // number of stars is the array index
        int[] distribution = new int[NUMBER_OF_BUCKETS];
        for (int grade : this.grades) {
            if (grade >= FIVE_STARS && grade <= MAX_GRADE) {
                distribution[5]++;
            }
            else if (grade >= FOUR_STARS) {
                distribution[4]++;
            }
            else if (grade >= THREE_STARS) {
                distribution[3]++;
            }
            else if (grade >= TWO_STARS) {
                distribution[2]++;
            }
            else if (grade >= ONE_STAR) {
                distribution[1]++;
            }
            else if (grade >= FAILED) {
                distribution[0]++;
            }
        }
        
        // print it
        System.out.println("Grade distribution:");
        for (int i = NUMBER_OF_BUCKETS - 1; i >= 0; i--) {
            StringBuffer buf = new StringBuffer("");
            for (int j = 0; j < distribution[i]; j++) {
                buf.append("*");
            }
            System.out.printf("%d: %s\n", i, buf);
        }
        
        // acceptance
        int size = grades.size();
        if (size > 0) {
            int accepted = size - distribution[0];
            double acceptanceRate = 100.0 * accepted / size;
            System.out.printf("Acceptance percentage: %f\n", acceptanceRate);
        }
        else {
            System.out.println("fuck you");
        }
    }
}
