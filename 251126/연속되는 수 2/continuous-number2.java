import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int maxCnt = 1;
        int currCnt = 1;
        int curr = arr[0];

        for (int i = 1; i < n; i++) {
            if (curr == arr[i]) {
                currCnt++;
                maxCnt = Math.max(maxCnt, currCnt);
            } else {
                currCnt = 1;
                curr = arr[i];
            }
        }

        System.out.println(maxCnt);
    }
}