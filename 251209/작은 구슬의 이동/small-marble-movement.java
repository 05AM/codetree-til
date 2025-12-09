import java.util.Scanner;

public class Main {

    private static final int[] dr = new int[] {-1, 0, 0, 1};
    private static final int[] dc = new int[] {0, 1, -1, 0};

    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();

        int dirNum = getDirNum(D);
        while (T-- > 0) {
            int nextR = R + dr[dirNum];
            int nextC = C + dc[dirNum];

            if (inRange(nextR, nextC)) {
                R = nextR;
                C = nextC;
            } else {
                dirNum = 3 - dirNum;
            }
        }

        System.out.println(R + " " + C);
    }

    public static int getDirNum(String dir) {
        if (dir.equals("U")) {
            return 0;
        } else if (dir.equals("D")) {
            return 3;
        } else if (dir.equals("R")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
}