import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[][] distances;
    public static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        map = new int[N][M];
        distances = new int[N][M];

        int x = 0, y = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if(value == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        visit(x, y, 0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    sb.append("-1 ");
                } else {
                    sb.append(distances[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void visit(int x, int y, int distance) {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] <= 0) {
            return;
        }

        map[x][y] *= -1;
        distances[x][y] = distance;

        queue.add(new int[] {x - 1, y, distance + 1});
        queue.add(new int[] {x + 1, y, distance + 1});
        queue.add(new int[] {x, y - 1, distance + 1});
        queue.add(new int[] {x, y + 1, distance + 1});

        while(!queue.isEmpty()) {
            int[] nextNode = queue.poll();
            visit(nextNode[0], nextNode[1], nextNode[2]);
        }
    }
}
