import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
// ---------------------- 입력부 -------------------------------		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			ans[i] = Integer.parseInt(br.readLine());
		}
// -----------------------------------------------------------
		
		Stack st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int push = 1; // 스택에 push할 값을 제어
		int now = 0; // pop시 ans와 비교할 인덱스
		boolean flag = true; // 연산 수행 결과 얻을 수 있는 수열인지를 나타내는 플래그
		
		// 스택은 FILO이므로 ans의 뒤에서부터 탐색
		for(int i = n - 1; i >= 0 && push <= n; i--) { // i : ans의 인덱스를 제어
			// ans[i]의 값이 push값 보다 작다면 해당 수열은 스택을 통해 구현할 수 없음 (else 구문)
			if(ans[i] >= push) { 
				// 이후 ans[i] 값이 push가 될 때까지 push값 들을 stack에 넣고 빼기 
				while(ans[i] > push) {
					st.push(push++);
					sb.append("+\n");
					
					// ans의 앞에서부터 비교하는 now 인덱스가 가르키는 값과 st에 꼭대기에 위치한 값이 동일하면 pop, now인덱스 증가
					while(!st.isEmpty() && (int) st.peek() == ans[now]) {
						st.pop();
						sb.append("-\n");
						now++;
					}
				}
				
				st.push(push++);
				sb.append("+\n");
			} else {
				flag = false;
				break;
			}
		}
		
		// 이후 pop을 하는 과정
		if(flag) {
			while(!st.isEmpty()) {
				if((int) st.pop() == ans[now++]) {
					sb.append("-\n");
				} else {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
			
		br.close();
	}

}
