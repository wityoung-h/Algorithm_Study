import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String temp = br.readLine();
			
			if(temp.equals("."))
				break;
			
			sb.append(checkRight(temp) ? "yes" : "no").append("\n");
		}
	
		System.out.print(sb);
		
		br.close();
	}
	
	public static boolean checkRight(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(now == '(' || now == '[') // 왼쪽 괄호면 stack에 넣음
				stack.push(now);
			else if(now == ')') { // 오른쪽 괄호면 stack에서 괄호를 빼기 (비어 있으면 올바르지 못한 괄호)
				if(stack.empty()) 
					return false;
				else {
					if(stack.pop() != '(')
						return false;
				}
			} else if(now == ']')	{ // 오른쪽 괄호면 stack에서 괄호를 빼기 (비어 있으면 올바르지 못한 괄호)
				if(stack.empty()) 
					return false;
				else {
					if(stack.pop() != '[')
						return false;
				}
			}
		}
		
		// str을 모두 탐색 후 스택이 비어있어야 올바른 괄호 문자열
		if(stack.empty())
			return true;
		else
			return false;
	}
}
