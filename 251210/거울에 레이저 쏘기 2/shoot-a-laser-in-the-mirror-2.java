import java.util.Scanner;

public class Main {

    public static final int[] dr = new int[] { -1, 0, 1, 0 };
    public static final int[] dc = new int[] { 0, 1, 0, -1 };

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
        int startNum = sc.nextInt();

        // startNum이 어느 방향인지 구하기
        int dirNum;
        int r, c;
        if (startNum / 4 == 0) {
            dirNum = 2;
            r = 0;
            c = startNum % 4 - 1;
        } else if (startNum / 4 == 1) {
            dirNum = 3;
            r = startNum % 4 - 1;
            c = n - 1;
        } else if (startNum / 4 == 2) {
            dirNum = 0;
            r = n - 1;
            c = startNum % 4 - 1;
        } else {
            dirNum = 1;
            r = startNum % 4 - 1;
            c = n - 1;
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
            if (currDirNum == 0 || currDirNum == 1) {
                return (currDirNum + 1) % 4;
            } else {
                return (currDirNum - 1 + 4) % 4;
            }
        } else {
            if (currDirNum == 1 || currDirNum == 2) {
                return (currDirNum + 1) % 4;
            } else {
                return (currDirNum - 1 + 4) % 4;
            }
        }
    }
}