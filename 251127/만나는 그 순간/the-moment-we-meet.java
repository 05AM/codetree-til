import java.util.*;

public class Main {

    private static final int OFFSET = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Please write your code here.
        // 해당 시간에 어디 있었는지
        int[] a = new int[OFFSET];
        Arrays.fill(a, OFFSET);
        int loc = 0;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                loc += d.equals("R") ? 1 : -1;
                a[idx++] = loc;
            }
        }

        int[] b = new int[OFFSET];
        Arrays.fill(b, OFFSET);
        loc = 0;
        idx = 0;

        for (int i = 0; i < m; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                loc += d.equals("R") ? 1 : -1;
                b[idx++] = loc;
            }
        }

        for (int i = 1; i < OFFSET; i++) {
            if (a[i] == OFFSET) break;

            if (a[i] == b[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}