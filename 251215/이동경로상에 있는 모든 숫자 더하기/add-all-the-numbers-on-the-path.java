import java.util.Scanner;

public class Main {

    private static final int[] dr = new int[] {-1, 0, 1, 0};
    private static final int[] dc = new int[] {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }


        int row = n / 2;
        int col = n / 2;
        int dirNum = 0;
        int result = board[row][col];

        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                dirNum = (dirNum - 1 + 4) % 4;
            } else if (command == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else if (command == 'F') {
                int nr = row + dr[dirNum];
                int nc = col + dc[dirNum];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    row = nr;
                    col = nc;
                    result += board[row][col];
                }
            }
        }

        System.out.println(result);
    }
}