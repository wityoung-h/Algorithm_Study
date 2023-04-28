import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue que = new LinkedList<Integer>();
				
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		while(que.size() != 1) {
			que.poll();
			que.add((int) que.poll());
		}
		
		System.out.print(que.poll());
		
		br.close();
	}
	
}
