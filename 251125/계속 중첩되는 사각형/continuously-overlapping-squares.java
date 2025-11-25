import java.util.Scanner;
public class Main {

    private static final int OFFSET = 100;
    private static final int MAX_SIDE = OFFSET * 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[MAX_SIDE][MAX_SIDE];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            int value = i % 2 == 0 ? 1 : 2;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    board[x][y] = 1;
                }
            }
        }

        int sum = 0;
        for (int x = 0; x < MAX_SIDE; x++) {
            for (int y = 0; y < MAX_SIDE; y++) {
                if (board[x][y] == 2) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}