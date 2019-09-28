import java.util.Random;

public class PasswordRandomizer {
    // Define the variables
    private int length;
    private Random random;
    
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.length = length;
        this.random = new Random();
    }

    public String createPassword() {
        // write code that returns a randomized password
        char[] chars = new char[this.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = LETTERS.charAt(this.random.nextInt(26));
        }
        return new String(chars);
    }
}
