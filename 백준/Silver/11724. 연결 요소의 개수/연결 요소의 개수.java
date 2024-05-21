import java.io.*;

public class Main {
    public static boolean[][] connected;
    public static boolean[] visited;
    public static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        connected = new boolean[N][N];
        visited = new boolean[N];

        for(int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]) - 1;
            int node2 = Integer.parseInt(nodes[1]) - 1;

            connected[node1][node2] = true;
            connected[node2][node1] = true;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                bfs(i);
                number++;
            }
        }

        System.out.println(number);

        br.close();
    }

    public static void bfs(int node) {
        visited[node] = true;

        for(int i = 0; i < connected[0].length; i++) {
            if(connected[node][i] && !visited[i]) {
                bfs(i);
            }
        }
    }
}
