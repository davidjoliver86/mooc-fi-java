
public class Smileys {
    
    private static final String SMILEY = ":)";

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String s) {
        int stringLen = s.length();
        boolean odd = stringLen % 2 == 1;
        int smilies = (stringLen / 2) + 3;
        if (odd) {
            smilies += 1;
        }
        printLineOfSmileys(smilies);
        System.out.print(SMILEY + " ");
        System.out.print(s + " ");
        if (odd) {
            System.out.print(" ");
        }
        System.out.print(SMILEY + "\n");
        printLineOfSmileys(smilies);
    }
    
    private static void printLineOfSmileys(int smilies) {
        for (int i = 0; i < smilies; i++) {
            System.out.print(SMILEY);
        }
        System.out.println();
    }

}
