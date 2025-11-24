import java.util.Scanner;
public class Main {

    private static final int OFFSET = 100;
    private static final int SIDE = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        int[][] board = new int[OFFSET * 2][OFFSET * 2];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + OFFSET;
            y[i] = sc.nextInt() + OFFSET;

            for (int r = x[i]; r < x[i] + SIDE; r++) {
                for (int c = y[i]; c < y[i] + SIDE; c++) {
                    board[r][c] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}