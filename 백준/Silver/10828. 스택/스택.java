import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			
			if(temp[0].equals("push")) {
				stack.push(Integer.parseInt(temp[1]));
				continue;
			} else if(temp[0].equals("pop")) {
				sb.append(stack.empty()? -1 : stack.pop());
			} else if(temp[0].equals("size")) {
				sb.append(stack.size());
			} else if(temp[0].equals("empty")) {
				sb.append(stack.empty()? 1 : 0);
			} else {
				sb.append(stack.empty()? -1 : stack.peek());
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
