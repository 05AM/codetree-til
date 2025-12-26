import java.util.Scanner;

public class Main {
    static int k, n;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        selected = new int[n];

        solution(0);
    }

    private static void solution(int i) {
        if (i == n) {
            // 출력
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                result.append(selected[j]).append(" ");
            }

            System.out.println(result);
        } else {
            for (int value = 1; value <= k; value++) {
                selected[i] = value;
                solution(i + 1);
            }
        }
    }
}