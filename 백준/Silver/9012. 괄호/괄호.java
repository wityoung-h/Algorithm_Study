import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			sb.append(checkRight(br.readLine()) ? "YES" : "NO").append("\n");
		}
	
		System.out.print(sb);
		
		br.close();
	}
	
	public static boolean checkRight(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') // 왼쪽 괄호면 stack에 넣음
				stack.push('(');
			else { // 오른쪽 괄호면 stack에서 괄호를 빼기 (비어 있으면 올바르지 못한 괄호)
				if(stack.empty()) 
					return false;
				else
					stack.pop();
			}	
		}
		
		// str을 모두 탐색 후 스택이 비어있어야 올바른 괄호 문자열
		if(stack.empty())
			return true;
		else
			return false;
	}
}
