import java.util.Scanner;
public class Main {

    private static final int[] dr = new int[] {0, 1, -1, 0};
    private static final int[] dc = new int[] {-1, 0, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = 0, c = 0;

        int result = -1;
        int t = 0;

        for (int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int dirNum = getDirNum(dir);

            for (int j = 0; j < dist; j++) {
                r += dr[dirNum];
                c += dc[dirNum];
                t++;

                if (r == 0 && c == 0) {
                    result = t;
                    break;
                }
            }

            if (result != -1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static int getDirNum(char dir) {
        if (dir == 'W') {
            return 0;
        } else if (dir == 'S') {
            return 1;
        } else if (dir == 'N') {
            return 2;
        } else {
            return 3;
        }
    }
}