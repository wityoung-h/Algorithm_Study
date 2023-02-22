import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int N;
	public static long temp = 0; // 계산값을 저장할 변수
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
		
		calculate(0);
		
		Collections.sort(result); // 계산된 값을 오름차순으로 정렬
		
		System.out.print(result.get(result.size() - 1) + "\n" + result.get(0));
		
		br.close();
	}
	
	// 모든 연산자를 계산할 dfs 탐색 함수
	public static void calculate(int depth) {
		// 모든 연산자를 사용하였으면(수 배열의 모든 값을 사용하였으면) 계산값을 저장하고 탐색 종료
		if(depth == N) {
			result.add(temp);
			return;
		}
		
		// depth가 0일 떄, 계산값을 저장할 temp를 첫번째 수로 지정
		if(depth == 0) {
			temp = array[0];
			calculate(depth + 1); //다음 깊이(= 다음 연산자) 탐색
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] != 0) {
				operator[i]--; // operator를 사용했으므로 해당 연산자 값 하나 줄이기
				if(i == 0) { // 덧셈 연산자
					temp += array[depth];
					calculate(depth + 1);
					temp -= array[depth];
				} else if(i == 1) { // 뺄셈 연산자
					temp -= array[depth];
					calculate(depth + 1);
					temp += array[depth];
				} else if(i == 2) { // 곱셈 연산자
					temp *= array[depth];
					calculate(depth + 1);
					temp /= array[depth];
				} else { // 나눗셈 연산자
					// 나머지를 기억해두어야 depth + 1 탐색 후 돌아왔을 때 원래 값으로 되돌릴 수 있음
					long remainder = temp % array[depth];
					temp /= array[depth];
					calculate(depth + 1);
					temp *= array[depth];
					temp += remainder;
				}
				operator[i]++; // operator 사용이 끝났으므로 해당 연산자 값 다시 늘리기
			}
		}
	}
}