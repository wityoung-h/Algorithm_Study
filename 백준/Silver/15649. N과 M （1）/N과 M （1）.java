// 참고 - https://st-lab.tistory.com/114

import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
	public static boolean[] visit;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// visit : 방문 여부를 확인할 배열
		// arr : 출력할 값을 저장할 배열
		visit = new boolean[N];
		arr = new int[M];
		
		System.out.print(dfs(N, M, 0));

		br.close();
	}
	
	public static String dfs(int N, int M, int depth) {
		StringBuilder sb = new StringBuilder();
		
		// depth == M이면 arr에 저장된 값을 return
		if(depth == M) {			
			for(int val:arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			String str = sb.toString();
			
			return str;
		}
		
		for(int i = 0; i < N; i++) {
			// 수 (i + 1) - (index : i) 를 방문한 적이 없다면 
			if(!visit[i]) {
				visit[i] = true; // 방문 체크
				arr[depth] = i + 1; // 현재 값을 저장
				// 깊이 + 1 하여 나머지 값을 결정, 저장된 값을 출력
				sb.append(dfs(N, M, depth + 1)); 
				
				// 해당 값의 탐색이 끝났으므로 방문 여부를 false로 다시 변경
				visit[i] = false;
			}
			// 수 (i + 1) - (index : i) 를 방문한 적이 있다면 그 다음 값으로 넘어감 
		}
		
		String result = sb.toString();
		return result;
	}
}