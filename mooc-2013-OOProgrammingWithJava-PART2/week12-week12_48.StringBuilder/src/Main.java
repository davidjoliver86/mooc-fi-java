
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n ");
        int len = t.length;
        for (int i = 0; i < len; i++) {
            sb.append(t[i]);
            if (i != (len - 1)) {
                if (i % 4 == 3) {
                    sb.append(",\n ");
                } else {
                    sb.append(", ");
                }
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
