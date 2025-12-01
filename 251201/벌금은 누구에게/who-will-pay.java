import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }

        int[] result = new int[n + 1];
        int first = -1;
        for (int id : penalizedPerson) {
            result[id]++;
        
            if (result[id] == k) {
                first = id;
                break;
            }
        }

        System.out.println(first);
    }
}