import java.util.Scanner;
public class Main {

    private static final int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }

        // Please write your code here.
        int[][] board = new int[OFFSET * 2][OFFSET * 2];
        for (int i = 0; i < n; i++) {
            for (int r = x1[i]; r < x2[i]; r++) {
                for (int c = y1[i]; c < y2[i]; c++) {
                    board[r][c] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}