import java.util.ArrayList;
import java.util.Random;

public class LotteryNumbers {
    private ArrayList<Integer> numbers;
    private Random random;
    private static final int SIZE = 7;
    private static final int MAX_NUMBER = 39;

    public LotteryNumbers() {
        // Draw numbers as LotteryNumbers is created
        this.numbers = new ArrayList<Integer>();
        this.random = new Random();
        this.drawNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void drawNumbers() {
        this.numbers.clear();
        while (this.numbers.size() < SIZE) {
            int n = this.random.nextInt(MAX_NUMBER) + 1;
            if (!containsNumber(n)) {
                this.numbers.add(n);
            }
        }
    }

    public boolean containsNumber(int number) {
        // Test here if the number is already in the drawn numbers
        return this.numbers.contains(number);
    }
}
