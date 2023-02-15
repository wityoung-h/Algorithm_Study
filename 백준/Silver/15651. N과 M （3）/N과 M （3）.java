import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
	public static int[] arr; // 값을 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		
		System.out.print(dfs(N, M, 0));

		br.close();
	}
	
	public static String dfs(int N, int M, int depth) {
		StringBuilder sb = new StringBuilder();
		
		// 깊이가 M이 되었다면 해당 배열을 출력
		if(depth == M) {
			for(int val:arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return sb.toString();
		}

		for(int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			sb.append(dfs(N, M, depth + 1));
		}
		return sb.toString();
	}
}