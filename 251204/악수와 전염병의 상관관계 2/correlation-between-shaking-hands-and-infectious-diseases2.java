import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();    // 악수한 시간
            shakes[i][1] = sc.nextInt();    // 개발자1
            shakes[i][2] = sc.nextInt();    // 개발자2
        }
        // Please write your code here.
        // 초 순서대로 정렬
        Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));

        // 초가 지나면서 누가 감염됐는지 표시 + 감염 후 몇 초가 지났는지 기록
        boolean[] isInfected = new boolean[N + 1];
        int[] afterInfected = new int[N + 1];
        isInfected[P] = true;
        afterInfected[P] = 1;

        // 결과: 각 개발자의 양성/음성 여부
        for (int[] shake : shakes) {
            int x = shake[1];
            int y = shake[2];

            if (isInfected[x] && afterInfected[x] <= K || isInfected[y] && afterInfected[y] <= K) {
                isInfected[y] = true;
                isInfected[x] = true;

                afterInfected[y] += 1;
                afterInfected[x] += 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(isInfected[i] ? 1 : 0);
        }
    }
}