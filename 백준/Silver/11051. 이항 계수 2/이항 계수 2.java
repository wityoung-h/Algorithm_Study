import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long[][] fib = new long[1001][1001]; // fib[N][K] N_K의 이항계수를 저장할 배열 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long ans = setFib(N, K);
 			
 		System.out.print(ans);
		br.close();
	}
	
	public static long setFib(int n, int r) {
		// 이항 계수 : 피보나치 수열, 조합
		// n+1Cr+1 = nCr + nCr+1 : nCr = n-1Cr-1 + n-1Cr
		
		if(r == 0 || r == n) {
			fib[n][r] = 1;
			return 1;
		}
		
		if(fib[n][r] != 0)
			return fib[n][r];
		
		fib[n][r] = (setFib(n - 1, r- 1) + setFib(n - 1, r)) % 10007;
		return fib[n][r];
	}
}