import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
public class Main {
	static int arr[][] = new int[30][30];
	public static void main(String args[]) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(comb(M, N)).append('\n');
		}

		System.out.print(sb);
		br.close();
	}
	
	static int comb(int a, int b) {
		if(arr[a][b] > 0) return arr[a][b];
		if(a == b || b == 0) return arr[a][b] = 1;
		return arr[a][b] = comb(a-1, b-1)+comb(a-1, b);
	}
}