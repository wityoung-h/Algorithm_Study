import java.io.*;

public class Main {
    public static int[] number = new int[1001];

    public static void main(String[] args) throws IOException {
        number[1] = 1;
        number[2] = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(cal(N));

        br.close();
    }

    public static int cal(int N) {
        if(number[N] != 0) {
            return number[N];
        }

        return number[N] = (int) (((long) cal(N - 1) + cal(N - 2)) % 10007);
    }
}
