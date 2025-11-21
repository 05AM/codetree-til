import java.util.Scanner;
public class Main {

    private static final int WHITE = 1;
    private static final int BLACK = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int offset = 100 * n;
        int[] result = new int[2 * offset];

        int curr = offset;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            while (x-- > 0) {
                if (d == 'L') {
                    result[curr] = WHITE;
                } else if (d == 'R') {
                    result[curr] = BLACK;
                }

                if (x != 0) {
                    curr += d == 'L' ? -1 : 1;
                }
            }
        }

        int white = 0;
        int black = 0;
        for (int i = 0; i < result.length; i ++) {
            if (result[i] == WHITE) {
                white++;
            } else if (result[i] == BLACK) {
                black++;
            }
        }

        System.out.println(white + " " + black);
    }
}