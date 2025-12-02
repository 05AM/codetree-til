import java.util.*;

public class Main {

    private static final int OFFSET = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[2*OFFSET + 1];
        Arrays.fill(a, OFFSET);

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
        
        int[] b = new int[2*OFFSET + 1];
        Arrays.fill(b, OFFSET);

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
        for (int i = 1; i <= OFFSET; i++) {
            if (a[i] == OFFSET && b[i] == OFFSET) {
                break;
            }

            int aCurr = a[i] != OFFSET ? i : aLoc;
            int bCurr = b[i] != OFFSET ? i : bLoc;
            aLoc = aCurr;
            bLoc = bCurr;

            // System.out.println("i: " + i + ", a: " + a[aLoc] + ", b: " + b[bLoc]);

            if (a[aLoc] == b[bLoc]) {
                if (aLoc != i || bLoc != i) {
                    result++;
                } else if (a[aLoc - 1] != b[bLoc - 1]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}