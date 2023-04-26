import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NS = br.readLine().split(" ");
		int N = Integer.parseInt(NS[0]);
		int S = Integer.parseInt(NS[1]);

		String[] nums = br.readLine().split(" ");
		int min = Integer.MAX_VALUE;
		int head = 0, tail = 0; 
		int sum = 0;
		
		while(head < nums.length) {
			if(sum < S) {
				if (tail < nums.length) {
					sum += Integer.parseInt(nums[tail++]);
				} else {
					break;
				}
			} else {
				min = (tail - head < min) ? (tail - head) : min;
				sum -= Integer.parseInt(nums[head++]);
			}
		}
		
		if(min == Integer.MAX_VALUE)
			min = 0;
		
		System.out.print(min);
		
		br.close();
	}

}
