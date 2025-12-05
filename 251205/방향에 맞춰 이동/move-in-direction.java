import java.util.Scanner;
public class Main {

    private static int[] dx = { -1, 0, 0, 1 };
    private static int[] dy = { 0, -1, 1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            int dirNum;
            if (direction == 'W')
                dirNum = 0;
            else if (direction == 'S')
                dirNum = 1;
            else if (direction == 'N')
                dirNum = 2;
            else
                dirNum = 3;

            x += dx[dirNum] * distance;
            y += dy[dirNum] * distance;
        }

        System.out.println(x + " " + y);
    }
}