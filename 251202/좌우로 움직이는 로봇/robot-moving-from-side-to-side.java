import java.util.*;

public class Main {

    private static final int OFFSET = 100000;
    private static final int LIMIT = OFFSET * 2;

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

        // 현재 a와 b의 인덱스 값
        aLoc = 0;
        bLoc = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (a[i] == LIMIT + 1 && b[i] == LIMIT + 1) {
                break;
            }

            aLoc = a[i] != LIMIT + 1 ? i : aLoc;
            bLoc = b[i] != LIMIT + 1 ? i : bLoc;

            // System.out.println("i: " + i + ", a: " + a[aLoc] + ", b: " + b[bLoc]);

            if (a[aLoc] == b[bLoc]) {
                if (aLoc == i && bLoc == i) {
                    if (a[aLoc - 1] != b[bLoc - 1]) {
                        result++;
                        // System.out.println("checked1");
                    }
                } else if (aLoc == i) {
                    if (a[aLoc] != a[aLoc - 1]) {
                        result++;
                        // System.out.println("checked2");
                    }
                } else if (bLoc == i) {
                    if (b[bLoc] != b[bLoc - 1]) {
                        result++;
                        // System.out.println("checked3");
                    }
                }
            }
        }

        System.out.println(result);
    }
}