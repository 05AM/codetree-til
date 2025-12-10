import java.util.Scanner;

public class Main {

    public static final int[] dr = new int[] { 1, 0, -1, 0 };
    public static final int[] dc = new int[] { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt() - 1;

        // startNum이 어느 방향인지 구하기
        int dirNum;
        int r, c;
        if (startNum / n == 0) {
            dirNum = 0;
            r = 0;
            c = startNum % n;
        } else if (startNum / n == 1) {
            dirNum = 1;
            r = startNum % n;
            c = n - 1;
        } else if (startNum / n == 2) {
            dirNum = 2;
            r = n - 1;
            c = n - (startNum % n) - 1;
        } else {
            dirNum = 3;
            r = n - (startNum % n) - 1;
            c = 0;
        }

        // 어느 방향에서 들어왔는지, 거울이 무슨 방향인지 정보가 필요
        // 현재 방향으로 판단?
        int result = 0;

        while(true) {
            result++;

            char mirror = grid[r][c];
            dirNum = getDirNum(mirror, dirNum);

            r += dr[dirNum];
            c += dc[dirNum];

            if (r < 0 || r >= n || c < 0 || c >= n) {
                break;
            }
        }

        System.out.println(result);
    }

    public static int getDirNum(char mirror, int currDirNum) {
        if (mirror == '/') {
            return currDirNum ^ 1;
        } else {
            return 3 - currDirNum;
        }
    }
}