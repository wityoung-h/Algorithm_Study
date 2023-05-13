import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
				
		for(int i = 0; i < T; i++) {
			String[] nums = br.readLine().split(" ");
			
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);
			
			String[] prior_str = br.readLine().split(" ");
			// 연결된 큐를 탐색하며 MAX 중요도를 매번 뽑는 방법과
			// 입력된 중요도 값을 정렬하여 max값을 비교하는 방법
			// 두 가지 방안이 떠올랐고, 문서의 개수가 100개로 많지 않아 후자를 사용하기로 함
			
			int[] prior = new int[N];
			Queue que = new LinkedList<int[]>(); // int[]인 이유? : 중복 값이 존재하므로 인덱스 정보도 함께 저장되어야 함

			for(int j = 0; j < N; j++) {
				prior[j] = Integer.parseInt(prior_str[j]);
				que.add(new int[] {j, prior[j]});
			}
			
			Arrays.sort(prior);
			int order = 0;
			
			for(int j = N - 1; j >= 0;) {
				int[] temp = (int[]) que.poll();
				
				if(temp[1] == prior[j]) {
					order++;
					j--;
					if(temp[0] == M)
						break;
				} else {
					que.add(temp);
				}
			}
			
			sb.append(order + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}