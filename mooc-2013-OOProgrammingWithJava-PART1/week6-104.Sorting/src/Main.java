
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);
    }

    public static void sort(int[] array) {
        for (int index = 0; index < array.length; index++) {
            int smallestIndex = indexOfTheSmallestStartingFrom(array, index);
            swap(array, index, smallestIndex);
            System.out.println(Arrays.toString(array));
        }
    }

    public static int smallest(int[] arr) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] arr) {
        return indexOfTheSmallestStartingFrom(arr, 0);
    }

    public static int indexOfTheSmallestStartingFrom(int[] arr, int index) {
        // write the code here
        int smallest = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
