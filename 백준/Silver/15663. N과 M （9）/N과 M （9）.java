import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();

        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[N];

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            for(int i = 0; i < o1.size(); i++) {
                if(o1.get(i) != o2.get(i))
                    return o1.get(i) - o2.get(i);
            }
            return 0;
        });

        pickNumbers(queue, numbers, visited, 0, M, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);

        while(!queue.isEmpty()) {
            List<Integer> now = queue.poll();

            if(isSame(temp, now)) {
                continue;
            }
            temp = now;

            for(int j = 0; j < M; j++) {
                sb.append(now.get(j) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static boolean isSame(List<Integer> o1, List<Integer> o2) {
        for(int i = 0; i < o1.size(); i++) {
            if(!o1.get(i).equals(o2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void pickNumbers(PriorityQueue<List<Integer>> queue, List<Integer> numbers, boolean[] visited, int nowDep, int objDep,  List<Integer> list) {
        if(nowDep == objDep) {
            queue.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < numbers.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(numbers.get(i));
                pickNumbers(queue, numbers, visited, nowDep + 1, objDep, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
