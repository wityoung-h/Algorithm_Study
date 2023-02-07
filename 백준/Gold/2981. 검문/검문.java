import java.io.*;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
	// A = M * x1 + r, B = M * x2 + r, C = M * x3 + r 이라고 하면
	// A - B = M * (x1 - x2)이므로 M은 (A - B)의 약수이며,
	// B - C = M * (x2 - x3)이므로 M은 (B - C)의 약수기도 함
	// 즉, M은 (A - B), (B - C)의 공약수이며, 두 수의 최대 공약수를 찾아 약수를 찾는다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
 		StringBuilder sb = new StringBuilder();
		int GCD = 0;
		
 		for(int i = 0; i < N; i++) {
 			nums[i] =  Integer.parseInt(br.readLine());
 			
 			if(i == 1) {
 				GCD = Math.abs(nums[0] - nums[1]);
 			} else if (i != 0) {
 				GCD = findGCD(Math.abs(nums[i] - nums[i - 1]), GCD);
 			}
 		}
 		
 		for(int i = 2; i <= GCD; i++) {
 			if(GCD % i == 0)
 				sb.append(i + " ");
 		}
 		
 		 		
 		System.out.print(sb);
		br.close();
	}
	
    // GCD를 찾는 함수
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