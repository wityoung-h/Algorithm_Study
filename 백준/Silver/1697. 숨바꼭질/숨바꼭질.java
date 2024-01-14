import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        findMin(visited, N, K);
        visited[N] = 0;

        System.out.print(visited[K]);
    }

    public static void findMin(int[] visited, int start, int des) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 0; i < 3; i++) {
                int temp = 0;

                if(i == 0) {
                    temp = 2 * now;
                } else if (i == 1) {
                    temp = now + 1;
                } else {
                    temp = now - 1;
                }

                if(temp >= 0 && temp < 100001 && visited[temp] == -1) {
                    queue.add(temp);
                    visited[temp] = visited[now] + 1;
                }

                if(temp == des) {
                    return;
                }
            }
        }
    }
}