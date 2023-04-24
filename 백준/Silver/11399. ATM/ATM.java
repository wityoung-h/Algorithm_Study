import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] min_s = br.readLine().split(" ");
		int[] min = new int[N];
		
		for(int i = 0; i < N; i++) {
			min[i] = Integer.parseInt(min_s[i]);
		}
		
		// 시간이 적게 걸리는 사람이 앞에 서야 총 대기 시간이 줄어듦
		Arrays.sort(min);
		
		// sum : 대기시간의 합계, min[0]값으로 초기화 후 index = 1부터 탐색
		int sum = min[0];

		for(int i = 1; i < N; i++) {
			min[i] += min[i - 1];
			
			sum += min[i];
		}
		
		System.out.print(sum);
		
		br.close();
	}

}
