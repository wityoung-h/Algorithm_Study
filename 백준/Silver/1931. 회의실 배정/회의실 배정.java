import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 해결 전략
// 그리디 알고리즘
// 종료 시간이 짧은 것을 먼저 선택한다

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetingList = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            meetingList[i] = new int[]{ Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) };
        }

        // 정렬 기준 1 : 종료 시간 오름차순
        // 정렬 기준 2 : 시작 시간 오름차순
        Arrays.sort(meetingList, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 1;
        int prev = 0;

        for(int i = 1; i < N; i++) {
            if(meetingList[i][0] >= meetingList[prev][1]) {
                cnt++;
                prev = i;
            }
        }

        System.out.println(cnt);
    }


}