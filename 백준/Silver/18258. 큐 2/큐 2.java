import java.io.*;

public class Main {
	public static int[] arr;
	public static int front = 0;
	public static int rear = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			
			if(tmp.contains("push")) {
				String[] nums = tmp.split(" ");
				push(Integer.parseInt(nums[1]));
			} else if(tmp.contains("pop")) {
				sb.append(pop() + "\n");
			} else if(tmp.contains("size")) {
				sb.append(size() + "\n");
			} else if(tmp.contains("empty")) {
				sb.append(empty() + "\n");
			} else if(tmp.contains("front")) {
				sb.append(front() + "\n");
			} else {
				sb.append(back() + "\n");
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static void push(int n) {
		arr[rear++] = n;
	}
	
	public static int pop() {
		if(empty() == 0) {
			return arr[front++];
		} else {
			return -1;
		}
	}
	
	public static int size() {
		return rear - front;
	}
	
	public static int empty() {
		return (front == rear) ? 1 : 0;
	}
		
	public static int front() {
		if(empty() == 0) {
			return arr[front];
		} else {
			return -1;
		}
	}
	
	public static int back() {
		if(empty() == 0) {
			return arr[rear - 1];
		} else {
			return -1;
		}
	}
}
