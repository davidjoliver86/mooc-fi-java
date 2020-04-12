
public class Main {

    public static boolean isAWeekDay(String string) {
        return string.toLowerCase().matches("(mon|tue|wed|thu|fri|sat|sun)");
    }

    public static boolean allVowels(String string) {
        return string.toLowerCase().matches("(a|e|i|o|u|ä|ö)+");
    }

    public static boolean clockTime(String string) {
        if (!string.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            return false;
        }
        String[] parts = string.split(":");
        if (Integer.parseInt(parts[0]) >= 24) {
            return false;
        }
        if (Integer.parseInt(parts[1]) >= 60) {
            return false;
        }
        if (Integer.parseInt(parts[2]) >= 60) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write test code here
    }
}
