import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int offset = N * 10;
        int[] result = new int[2 * offset];
        int curr = offset;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            // Please write your code here.
            for (int j = 0; j < x; j++) {
                int prev = curr;
                curr += (dir == 'R' ? 1 : -1);
                result[Math.min(prev, curr)]++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 2 * offset; i++) {
            if (result[i] >= 2) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}