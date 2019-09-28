public class PrintingLikeBoss {

    // copy or rewrite the method of Assignment 39.1 here
    public static void printStars(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printWhitespaces(int amount) {
        // 40.1
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    public static void printTriangle(int size) {
        // 40.2
        for (int row = 1; row <= size; row++) {
            printWhitespaces(size - row);
            printStars(row);
        }
    }

    public static void xmasTree(int height) {
        // 40.3
        // first row has (height-1) spaces
        // each row has 2*(height-1) + 1 stars
        // trunk is equivalent to row 2 done twice
        for (int row = 1; row <= height; row++) {
            printWhitespaces(height-row);
            printStars(2*(row-1) + 1);
        }
        for (int i = 0; i < 2; i++) {
            printWhitespaces(height-2);
            printStars(3);
        }
    }

    public static void main(String[] args) {
        // Tests do not use main, yo can write code here freely!

        printTriangle(5);
        System.out.println("---");
        xmasTree(4);
        System.out.println("---");
        xmasTree(10);
    }
}
