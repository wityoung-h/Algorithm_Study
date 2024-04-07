import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = new int[N];
        String[] str_arr = br.readLine().split(" ");
        arr[0] = Integer.parseInt(str_arr[0]);

        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(str_arr[i]) + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for(int x = 0; x < M; x++) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);

            int tmpA = arr[j - 1];
            int tmpB = (i < 2) ? 0 : arr[i - 2];

            sb.append(tmpA - tmpB + "\n");
        }

        System.out.println(sb);
        br.close();
    }

}
