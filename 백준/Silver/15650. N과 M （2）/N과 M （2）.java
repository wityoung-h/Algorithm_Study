// 15649번과 흡사한 풀이

import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
	public static boolean[] visit; //방문 여부를 체크할 배열
	public static int[] arr; // 값을 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		arr = new int[M];
		
		System.out.print(dfs(N, M, 0, 0));

		br.close();
	}
	
	// lastVisit : 가장 마지막에 방문한 값의 인덱스
	public static String dfs(int N, int M, int depth, int lastVisit) {
		StringBuilder sb = new StringBuilder();
		
		// 깊이가 M이 되었다면 해당 배열을 출력
		if(depth == M) {
			for(int val:arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return sb.toString();
		}
		
		// 오름차순으로 정렬되므로, 가장 마지막에 방문한 값보다 큰 값만 탐색해야함
		for(int i = lastVisit; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				sb.append(dfs(N, M, depth + 1, i));
				visit[i] = false;
			}
		}
		return sb.toString();
	}
}