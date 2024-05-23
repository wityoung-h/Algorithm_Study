import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[][] object = new int[N + 1][2];
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            String[] WV = br.readLine().split(" ");

            object[i][0] = Integer.parseInt(WV[0]);
            object[i][1] = Integer.parseInt(WV[1]);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(object[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - object[i][0]] + object[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }

}
