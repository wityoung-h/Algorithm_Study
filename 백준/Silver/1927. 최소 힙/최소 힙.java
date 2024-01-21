import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            switch (t) {
                case 0:
                    if(min_heap.isEmpty()) {
                        sb.append(0).append('\n');
                        continue;
                    }

                    sb.append(min_heap.poll()).append('\n');

                    break;
                default:
                    min_heap.add(t);
                    break;
            }
        }

        System.out.print(sb);
    }
}