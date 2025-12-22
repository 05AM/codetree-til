import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int max = Integer.parseInt(a, 2);
        for (int i = 0; i < a.length(); i++) {
            StringBuilder temp = new StringBuilder(a);

            if (temp.charAt(i) == '0') {
                temp.setCharAt(i, '1');
                max = Math.max(max, Integer.parseInt(temp.toString(), 2));
            }
        }

        System.out.println(max);
    }
}