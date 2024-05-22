import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static PriorityQueue<List<Integer>> queue;
    public static int[] numbers;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        queue = new PriorityQueue<>((o1, o2) -> {
            for(int i = 0; i < o1.size(); i++) {
                if(o1.get(i) != o2.get(i)) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        numbers = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new ArrayList<>(), 0, M);

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            List<Integer> now = queue.poll();

            for(int i = 0; i < now.size(); i++) {
                sb.append(now.get(i) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void dfs(List<Integer> list, int now, int object) {
        if(now == object) {
            queue.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                list.add(numbers[i]);
                visited[i] = true;
                dfs(list, now + 1, object);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
