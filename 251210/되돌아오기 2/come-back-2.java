import java.util.Scanner;
public class Main {

    private static final int[] dx = new int[] { -1, 0, 1, 0 };
    private static final int[] dy = new int[] { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();

        int dirNum = 0;
        int x = 0;
        int y = 0;
        int t = 0;
        int result = -1;

        for (char command : commands.toCharArray()) {
            t++;

            if (command == 'F') {
                x += dx[dirNum];
                y += dy[dirNum];

                if (x == 0 && y == 0) {
                    result = t;
                    break;
                }
            } else if (command == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else {
                dirNum = (dirNum - 1 + 4) % 4;
            }
        }

        System.out.println(result);
    }
}