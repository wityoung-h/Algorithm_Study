import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// nCm : n! / {m! * (n - m)!}
		int val5 = countFive(n) - countFive(m) - countFive(n - m);
		int val2 = countTwo(n) - countTwo(m) - countTwo(n - m);
		
		// 2와 5의 제곱 중 더 적게 존재하는 수가 0의 개수를 결정함
 		System.out.print(val5 > val2 ? val2 : val5);
		br.close();
	}
	
	// a! 값을 소인수 분해 했을 때 5의 제곱을 찾아주는 함수
	public static int countFive(int a) {
		int ans = 0;
		
		while(a >= 5) {
			ans += (a / 5);
			a /= 5;
		}
		
		return ans;
	}
	
	// a! 값을 소인수 분해 했을 때 2의 제곱을 찾아주는 함수
	public static int countTwo(int a) {
		int ans = 0;
		
		while(a >= 2) {
			ans += (a / 2);
			a /= 2;
		}
		
		return ans;
	}
}