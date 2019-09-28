
public class Main {

    public static void main(String[] args) {
        // test method here
        int[] array = {5, 1, 3, 4, 2};
        printElegantly(array);
    }

    public static void printElegantly(int[] array) {
        // Write code here
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.print(array[i]);
            if (i + 1 < len) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
