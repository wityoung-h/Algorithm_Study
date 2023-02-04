import java.io.*;
import java.util.Arrays;
import java.lang.StringBuilder;

public class D20230204_N2981_T {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
 		StringBuilder sb = new StringBuilder();
		
 		for(int i = 0; i < N; i++) {
 			nums[i] =  Integer.parseInt(br.readLine());
 		}
 		
 		// 입력된 수를 차례대로 정렬
 		Arrays.sort(nums);
		
 		// 수 % i = r, r이 모두 같은 값
 		// i < nums[N -1]인 이유? i >= nums[N - 1]이면 r은 i값에 관계 없이 수 원래의 값이 됨
 		for(int i = 2; i < nums[N - 1]; i++) {
 			int r = nums[0] % i;
 			boolean same = true; // flag on
 			
 			for(int j = 0; j < N; j++) {
 				if(nums[j] % i != r) {
 					// 나머지가 같지 않은 수가 있다면 flag off 루프를 탈출
 					same = false;
 					break;
 				}
 			}
 			
 			// flag가 꺼지지 않았다면 모든 수의 r이 동일하다는 뜻임
 			if(same) {
 				sb.append(i + " ");
 			}
 		}
 		 		
 		System.out.print(sb);
		br.close();
	}
}
