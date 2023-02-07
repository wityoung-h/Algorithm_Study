import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// 이항 계수 : 조합(nCr)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 1; int fac = 1;
 		
		// nCr = n * (n - 1) * ... * (n - r) / r!
		for(int i = 1; i <= K; i++) {
			ans *= N--;
			fac *= i;
		}
		
		ans /= fac;
 			
 		System.out.print(ans);
		br.close();
	}
}