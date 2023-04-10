import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack stack = new Stack<Integer>();
		
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				int m = (int) stack.pop();
				sum -= m;
			} else {
				stack.push(n);
				sum += n;
			}
		}
	
		System.out.print(sum);
		
		br.close();
	}
}
