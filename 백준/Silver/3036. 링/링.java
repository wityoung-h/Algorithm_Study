import java.io.*;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] tmp = br.readLine().split(" ");
		int[] nums = new int[N];
 		StringBuilder sb = new StringBuilder();
				
 		for(int i = 0; i < N; i++) {
 			nums[i] =  Integer.parseInt(tmp[i]);
 			
 			// nums[0] / nums[i]의 기약 분수? 두 수의 최소공배수를 찾은 뒤 나눠준다.
 			if(i != 0) {
 				int a = nums[0]; int b = nums[i];
 				int GCD = findGCD(a, b);
 				sb.append(a / GCD + "/" + b / GCD + "\n");
 			}
 		}
 				
 		System.out.print(sb);
		br.close();
	}
	
	public static int findGCD(int a, int b) {
		int max = a - b > 0 ? a : b; // a와 b 중 큰 값 찾기
		int min = a - b > 0 ? b : a; // a와 b 중 작은 값 찾기
		
		int GCD = 0;
		
		while(true) {
			int r = max % min;
			
			if(r == 0) {
				GCD = min;
				break;
			}
			
			max = min;
			min = r;
		}
		
		return GCD;
	}
}