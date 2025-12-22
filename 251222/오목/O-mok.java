import java.util.Scanner;

public class Main {

    private static final int n = 19;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 시작 위치 정하기
        int winner = 0;
        int midR = 0;
        int midC = 0;
        boolean isDetermined = false;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int curr = arr[r][c];
                // 가로, 세로, 대각선으로 5개 있는지 확인
                // 가로, 세로: 오른쪽 / 아래

                for (int i = 1; i <= 4; i++) {
                    int nr = r + i;
                    if (!inRange(nr, c)) {
                        break;
                    }

                    if (i == 2) {
                        midR = nr;
                        midC = c;
                    }

                    if (arr[nr][c] == curr) {
                        if (i == 4) {
                            isDetermined = true;
                        }

                        continue;
                    }
                }

                
                for (int i = 1; i <= 4; i++) {
                    int nc = c + i;
                    if (!inRange(r, nc)) {
                        break;
                    }

                    if (i == 2) {
                        midR = r;
                        midC = nc;
                    }

                    if (arr[r][nc] == curr) {
                        if (i == 4) {
                            isDetermined = true;
                        }

                        continue;
                    }
                }

                // 대각선: 아래 왼쪽 / 아래 오른쪽
                for (int i = 1; i <= 4; i++) {
                    int nr = r - i;
                    int nc = c - i;

                    if (!inRange(nr, nc)) {
                        break;
                    }

                    if (i == 2) {
                        midR = nr;
                        midC = nc;
                    }

                    if (arr[nr][nc] == curr) {
                        if (i == 4) {
                            isDetermined = true;
                        }

                        continue;
                    }
                }   

                for (int i = 1; i <= 4; i++) {
                    int nr = r + i;
                    int nc = c + i;

                    if (!inRange(nr, nc)) {
                        break;
                    }

                    if (i == 2) {
                        midR = nr;
                        midC = nc;
                    }

                    if (arr[nr][nc] == curr) {
                        if (i == 4) {
                            isDetermined = true;
                        }

                        continue;
                    }
                }   

                if (isDetermined) {
                    winner = curr == 1 ? 1 : 2;
                    break;
                }
            }

            if (isDetermined) {
                break;
            }
        }

        System.out.println(winner);
        if (winner != 0) {
            System.out.println(midR + " " + midC);
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}