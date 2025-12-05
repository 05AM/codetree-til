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

            switch (direction) {
                case 'W': 
                    x += dx[0] * distance;
                    y += dy[0] * distance;
                    break;
                case 'S': 
                    x += dx[1] * distance;
                    y += dy[1] * distance;
                    break;
                case 'N': 
                    x += dx[2] * distance;
                    y += dy[2] * distance;
                    break;
                case 'E': 
                    x += dx[3] * distance;
                    y += dy[3] * distance;
                    break;
            }
        }

        System.out.println(x + " " + y);
    }
}