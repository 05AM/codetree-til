import java.util.Scanner;
public class Main {

    private static final int[] dr = new int[] { 1, 0, -1, 0 };
    private static final int[] dc = new int[] { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        int row = 0;
        int col = 0;
        int dirNum = 0;
        int number = 1;

        for (int i = 0; i < n * m; i++) {
            grid[row][col] = number++;

            int nr = row + dr[dirNum];
            int nc = col + dc[dirNum];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 0) {
                dirNum = (dirNum + 1) % 4;
                row += dr[dirNum];
                col += dc[dirNum];
            } else {
                row = nr;
                col = nc;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}