import java.util.*;

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[LIMIT + 1];
        Arrays.fill(a, LIMIT + 1);

        a[0] = 0;
        int aTime = 1;
        int aLoc = 0;

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-- > 0) {
                int v = d == 'R' ? 1 : -1;
                aLoc += v;
                a[aTime++] = aLoc;
            }
        }
        
        int[] b = new int[LIMIT + 1];
        Arrays.fill(b, LIMIT + 1);

        b[0] = 0;
        int bTime = 1;
        int bLoc = 0;

        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-- > 0) {
                int v = d == 'R' ? 1 : -1;
                bLoc += v;
                b[bTime++] = bLoc;
            }
        }

        int result = 0;
        if (aTime < bTime) {
            for (int i = aTime; i < bTime; i++) {
                a[i] = a[aTime - 1];
            }
        } else if (aTime > bTime) {
            for (int i = bTime; i < aTime; i++) {
                b[i] = b[bTime - 1];
            }
        }

        int timeMax = Math.max(aTime, bTime);
        for (int i = 1; i < timeMax; i++) {
            if (a[i] == b[i] && a[i - 1] != b[i - 1]) {
                result++;
            }
        }

        System.out.println(result);
    }
}