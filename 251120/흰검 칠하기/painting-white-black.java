import java.util.Scanner;
public class Main {

    static final int BASIC = 0;
    static final int WHITE = 2;
    static final int BLACK = -2;
    static final int GRAY = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int offset = 100 * N;

        int[] result = new int[2 * offset];
        int[] overlap = new int[2 * offset];
        int curr = offset;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            while (x-- > 0) {
                if (overlap[curr] >= 3) {
                    overlap[curr] += 1;
                    result[curr] = GRAY;
                } else {
                    result[curr] = (d == 'L' ? WHITE : BLACK); 
                    overlap[curr] += 1;
                }

                if (x != 0) {
                    curr += (d == 'L' ? -1 : 1);
                }
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == WHITE) {
                white++;
            } else if (result[i] == BLACK) {
                black++;
            } else if (result[i] == GRAY) {
                gray++;
            }
        }

        System.out.print(white + " " + black + " " + gray);
    }
}