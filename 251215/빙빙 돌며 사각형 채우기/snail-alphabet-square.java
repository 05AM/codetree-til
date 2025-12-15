import java.util.Scanner;
public class Main {

    private static final int[] dr = new int[] {0, 1, 0, -1};
    private static final int[] dc = new int[] {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Character[][] grid = new Character[n][m];

        int row = 0;
        int col = 0;
        char ch = 'A';
        int dirNum = 0;

        for (int i = 0; i < n * m; i++) {
            grid[row][col] = (char) (ch + i % 26);

            int nr = row + dr[dirNum];
            int nc = col + dc[dirNum];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != null) {
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