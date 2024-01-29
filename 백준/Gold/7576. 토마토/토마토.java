import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] box;
    public static Queue<int[]> riped = new LinkedList<>();
    public static int cntUnripe = 0;
    public static int days = -1;
    public static final int[] DX = {-1, 1, 0, 0};
    public static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int M = Integer.parseInt(tmp[0]);
        int N = Integer.parseInt(tmp[1]);

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if(box[i][j] == 1) {
                    riped.add(new int[] {i, j});
                } else if(box[i][j] == 0) {
                    cntUnripe++;
                }
            }
        }

        while (!riped.isEmpty()) {
            for(int i = riped.size(); i > 0; i--) {
                int[] now = riped.poll();

                for(int j = 0; j < 4; j++) {
                    int nextX = now[0] + DX[j];
                    int nextY = now[1] + DY[j];

                    if(nextX < 0 || nextY < 0 || nextX >= box.length || nextY >= box[0].length || box[nextX][nextY] != 0) {
                        continue;
                    }

                    box[nextX][nextY] = 1;
                    cntUnripe--;
                    riped.add(new int[] { nextX, nextY });
                }
            }
            days++;
        }


        if(cntUnripe == 0) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

}