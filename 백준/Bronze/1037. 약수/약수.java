import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] nums = str.split(" ");
		int[] num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(nums[i]);
		}
		
		Arrays.sort(num); // 입력된 수를 오름차 순으로 정렬
		
		// 입력된 약수 중 가장 큰 수와 가장 작은 수의 곱이 구하고자 하는 자연수
		int small = num[0];
		int large = num[N - 1];
		
		System.out.print((long) small * large);
		
		br.close();
	}
}
