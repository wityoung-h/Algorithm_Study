import java.io.*;
import java.lang.StringBuilder;

public class D20230204_N1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			String[] strs = str.split(" ");
			int[] num = new int[2];
			num[0] = Integer.parseInt(strs[0]); num[1] = Integer.parseInt(strs[1]);
			
			// max : 둘 중 큰 수, min : 둘 중 작은 수
			int max = num[0] - num[1] > 0 ? num[0] : num[1];
			int min = num[0] - num[1] > 0 ? num[1] : num[0];
			
			// 유클리드 호제법에 따르면, 최대공약수는
			// a > b일 때, GCD(a, b) = GCD(b, r = a % b) = ... x % r = 0이 되는 순간의 r이 최대 공약수 
			while(true) {
				int r = max % min;
				
				if(r == 0) {
					// 최소 공배수 = 수1 * 수2 / 최대 공약수 (= 최대 공약수 * (수1 / 최대공약수) * (수2 / 최대공약수)) 
					sb.append(num[0] * num[1] / min + "\n");
					break;
				}
				
				max = min;
				min = r;
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
 