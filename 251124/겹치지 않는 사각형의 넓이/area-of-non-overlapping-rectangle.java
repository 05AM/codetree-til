import java.util.Scanner;
public class Main {

    private static final OFFSET = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + OFFSET;
        int ay1 = sc.nextInt() + OFFSET;
        int ax2 = sc.nextInt() + OFFSET;
        int ay2 = sc.nextInt() + OFFSET;
        int bx1 = sc.nextInt() + OFFSET;
        int by1 = sc.nextInt() + OFFSET;
        int bx2 = sc.nextInt() + OFFSET;
        int by2 = sc.nextInt() + OFFSET;
        int mx1 = sc.nextInt() + OFFSET;
        int my1 = sc.nextInt() + OFFSET;
        int mx2 = sc.nextInt() + OFFSET;
        int my2 = sc.nextInt() + OFFSET;

        // Please write your code here.
        int[][] board = new int[2 * OFFSET][2 * OFFSET];
        for (int ar = ax1; ar < ax2; ar++) {
            for (int ac = ay1; ac < ay2; ac++) {
                board[ar][ac] = 1;
            }
        }

        for (int br = bx1; br < bx2; br++) {
            for (int bc = by1; bc < by2; bc++) {
                board[br][bc] = 1;
            }
        }

        for (int mr = mx1; mr < mx2; mr++) {
            for (int mc = my1; mc < my2; mc++) {
                board[mr][mc] = 2;
            }
        }

        int sum = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}