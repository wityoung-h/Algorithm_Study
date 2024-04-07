import java.io.*;

public class Main {
    public static int[] way = new int[12];
    public static void main(String[] args) throws IOException {
        way[1] = 1;
        way[2] = 2;
        way[3] = 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());


            sb.append(countWay(n) + "\n");
        }

        System.out.println(sb);
    }

    public static int countWay(int n) {
        if(way[n] == 0) {
            way[n] = countWay(n - 1) + countWay(n - 2) + countWay(n - 3);
        }

        return way[n];
    }
}