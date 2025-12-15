import java.util.Scanner;

public class Main {

    private static final int[] dr = new int[] {1, 0, -1, 0};
    private static final int[] dc = new int[] {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        int row = n / 2;
        int col = n / 2;
        int dirNum = 0;
        int num = 1;

        for (int i = 0; i < n * n; i++) {
            grid[row][col] = num++;

            int nextDirNum = (dirNum + 1) % 4;
            int nr = row + dr[nextDirNum];
            int nc = col + dc[nextDirNum];

            if (nr < 0 || nc >= n || grid[nr][nc] == 0) {
                dirNum = nextDirNum;
                row = nr;
                col = nc;
            } else {
                row += dr[dirNum];
                col += dc[dirNum];
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}