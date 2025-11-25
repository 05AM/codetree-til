import java.util.Scanner;

public class Main {

    private static final int OFFSET = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + OFFSET;
        int rect1_y1 = sc.nextInt() + OFFSET;
        int rect1_x2 = sc.nextInt() + OFFSET;
        int rect1_y2 = sc.nextInt() + OFFSET;

        int rect2_x1 = sc.nextInt() + OFFSET;
        int rect2_y1 = sc.nextInt() + OFFSET;
        int rect2_x2 = sc.nextInt() + OFFSET;
        int rect2_y2 = sc.nextInt() + OFFSET;

        // Please write your code here.
        int[][] board = new int[OFFSET * 2][OFFSET * 2];
        for (int x = rect1_x1; x < rect1_x2; x++) {
            for (int y = rect1_y1; y < rect1_y2; y++) {
                board[x][y] = 1;
            }
        }

        for (int x = rect2_x1; x < rect2_x2; x++) {
            for (int y = rect2_y1; y < rect2_y2; y++) {
                board[x][y] = 2;
            }
        }

        int minX = OFFSET * 2;
        int maxX = 0;
        int minY = OFFSET * 2;
        int maxY = 0;

        for (int x = 0; x < OFFSET * 2; x++) {
            for (int y = 0; y < OFFSET * 2; y++) {
                if (board[x][y] == 1) {
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                }
            }
        }

        int result = (maxX - minX + 1) * (maxY - minY + 1);
        System.out.println(result);
    }
}