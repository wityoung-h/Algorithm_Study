import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];

        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        System.out.println(findHeight(trees, 0, trees.length, M));


        br.close();
    }

    public static int findHeight(int[] trees, int begin, int end, int object) {
        // 기저 케이스
        if(end - begin == 1) {
            int point = begin;
            long pointSum = sumTree(trees, begin);

            if(pointSum > object) {
                // tree[begin] 높이로 자른 나무의 합이 M보다 큰 경우
                if(point == trees.length - 1) {
                    // 찾은 단 하나의 값이 가장 큰 나무인 경우
                    return trees[point] - object;
                }

                int addHeight = 0;
                long nowSum = pointSum;

                while(true) {
                    nowSum -= trees.length -1 -point;

                    if(nowSum < object) {
                        return trees[begin] + addHeight;
                    }

                    addHeight++;
                }
            } else if(pointSum < object) {
                // tree[begin] 높이로 자른 나무의 합이 M보다 작은 경우
                // 나무를 항상 가져갈 수 있으므로, point가 0인 경우는 고려하지 않음

                int minHeight = 0;
                long nowSum = pointSum;

                while(true) {
                    nowSum += trees.length - point;
                    minHeight++;

                    if(nowSum >= object) {
                        return trees[begin] - minHeight;
                    }
                }
            } else {
                return trees[begin];
            }
        }

        int mid = (end - begin) / 2 + begin;

        if(sumTree(trees, mid) > object) {
            // trees[mid]를 기준으로 자른 나무의 합이 M보다 클 때
            return findHeight(trees, mid, end, object);
        } else if(sumTree(trees, mid) < object) {
            // trees[mid]를 기준으로 자른 나무의 합이 M보다 작을 때
            return findHeight(trees, begin, mid, object);
        } else {
            // trees[mid]를 기준으로 자른 나무의 합이 M과 동일 할 떄
            return trees[mid];
        }
    }

    public static long sumTree(int[] trees, int begin) {
        long result = 0;

        for(int i = begin + 1; i < trees.length; i++) {
            result += trees[i] - trees[begin];
        }

        return result;
     }
}