import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            String num = String.valueOf(i);
            String reversed = new StringBuilder(num).reverse().toString();

            if (num.equals(reversed)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}