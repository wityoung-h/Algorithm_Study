import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int N;
	public static int[] array; // 입력된 수열을 저장할 배열
	public static int[] operator = new int[4]; // 연산자의 정보를 저장할 배열
	public static ArrayList result = new ArrayList<Long>(); // 계산된 값을 저장할 ArrayList
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		calculate(0, array[0]);
		
		Collections.sort(result); // 계산된 값을 오름차순으로 정렬
		
		System.out.print(result.get(result.size() - 1)+ "\n" + result.get(0));
		
		br.close();
	}
	
	// 모든 연산자를 계산할 dfs 탐색 함수
	public static void calculate(int depth, int num) {
		// 모든 연산자를 사용하였으면(수 배열의 모든 값을 사용하였으면) 계산값을 저장하고 탐색 종료
		if(depth == N - 1) {
			result.add(num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] != 0) {
				operator[i]--; // operator를 사용했으므로 해당 연산자 값 하나 줄이기
				// 다른 풀이 참고 후 변경 점 : if - else 구문을 switch-case구문으로,
				// 전역변수를 통해 (계산 - 탐색 후 역계산)하던 과정을 매개변수 전달로 간편히 함
				switch(i) {
				case 0:
					calculate(depth + 1, num + array[depth + 1]);
					break;
				case 1:
					calculate(depth + 1, num - array[depth + 1]);
					break;
				case 2:
					calculate(depth + 1, num * array[depth + 1]);
					break;
				case 3:
					calculate(depth + 1, num / array[depth + 1]);
					break;
				}
				operator[i]++; // operator 사용이 끝났으므로 해당 연산자 값 다시 늘리기
			}
		}
	}
}