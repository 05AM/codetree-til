import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int offset = 100 * N;

        int[] whiteCnt = new int[2 * offset];
        int[] blackCnt = new int[2 * offset];
        char[] lastColor = new char[2 * offset];

        int curr = offset;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            while (x-- > 0) {
                if (d == 'L') {
                    whiteCnt[curr] += 1;
                    lastColor[curr] = 'W';
                } else if (d == 'R') {
                    blackCnt[curr] += 1;
                    lastColor[curr] = 'B';
                }

                if (x != 0) {
                    curr += (d == 'L' ? -1 : 1);
                }
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for (int i = 0; i < lastColor.length; i++) {
            if (whiteCnt[i] >= 2 && blackCnt[i] >=2) {
                gray++;
            } else if (lastColor[i] == 'W') {
                white++;
            } else if (lastColor[i] == 'B') {
                black++;
            }
        }

        System.out.print(white + " " + black + " " + gray);
    }
}