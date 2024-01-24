import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        int rootCnt = Integer.parseInt(br.readLine());

        List<int[]> lists = new ArrayList<>();

        for(int i = 0; i < nodeCnt; i++) {
            lists.add(new int[nodeCnt]);
        }

        for(int i = 0; i < rootCnt; i++) {
            String[] temp = br.readLine().split(" ");

            int nodeA = Integer.parseInt(temp[0]);
            int nodeB = Integer.parseInt(temp[1]);

            lists.get(nodeA - 1)[nodeB - 1] = 1;
            lists.get(nodeB - 1)[nodeA - 1] = 1;
        }

        System.out.println(search(0, lists) - 1);
    }

    public static int search(int startNode, List<int[]> graph) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] isVisit = new boolean[graph.size()];

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(isVisit[now])
                continue;

            isVisit[now] = true;
            cnt++;
            int[] connected = graph.get(now);

            for(int i = 0; i < connected.length; i++) {
                if(connected[i] == 1) {
                    queue.add(i);
                }
            }
        }

        return cnt;
    }


}