import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        HashSet<Integer> set =  new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            String[] splits = br.readLine().split(" ");

            if(splits[0].equals("add")) {
                set.add(Integer.parseInt(splits[1]));
            } else if(splits[0].equals("remove")) {
                set.remove(Integer.parseInt(splits[1]));
            } else if(splits[0].equals("check")) {
                sb.append((set.contains(Integer.parseInt(splits[1]))) ? 1 : 0).append("\n");
            } else if(splits[0].equals("toggle")) {
                if(set.contains(Integer.parseInt(splits[1]))) {
                    set.remove(Integer.parseInt(splits[1]));
                } else {
                    set.add(Integer.parseInt(splits[1]));
                }
            } else if(splits[0].equals("all")) {
                set = new HashSet<>(Arrays.asList(arr));
            } else if(splits[0].equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb);

        br.close();
    }

}
