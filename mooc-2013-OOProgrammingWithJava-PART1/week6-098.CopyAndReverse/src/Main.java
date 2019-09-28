
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int[] copied = copy(original);

        // change the copied
        copied[0] = 99;

        // print both
        System.out.println("original: " + Arrays.toString(original));
        System.out.println("copied: " + Arrays.toString(copied));
    }
    
    public static int[] copy(int[] array) {
        int len = array.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[i] = array[i];
        }
        return newArr;
    }
    
    public static int[] reverseCopy(int[] array) {
        int len = array.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[i] = array[len - 1 - i];
        }
        return newArr;
    }

}
