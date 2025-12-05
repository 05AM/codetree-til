import java.util.Scanner;

public class Main {

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int x = 0;
        int y = 0;
        int dirNum = 0;
        for (char command : s.toCharArray()) {
            if (command == 'L') {
                dirNum = (dirNum + 3) % 4;
            } else if (command == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else if (command == 'F') {
                x += dx[dirNum];
                y += dy[dirNum];
            }
        }

        System.out.println(x + " " + y);
    }
}