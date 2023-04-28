import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nums = br.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int K = Integer.parseInt(nums[1]);
		
		LinkedList list = new LinkedList(1);
		
		for(int i = 2; i <= N; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(list.next != list) {
			for(int i = 0; i < K; i++) {
				list = list.next;
			}
			sb.append(list.remove() + ", ");
		}
		
		sb.append(list.remove());
		
		System.out.print("<" + sb + ">");
		br.close();
	}
}

// 원형 연결리스트 구현
class LinkedList {
	int num;
	LinkedList next;
	
	public LinkedList(int n) {
		num = n;
		this.next = this;
	}
	
	public LinkedList(int n, LinkedList next) {
		num = n;
		this.next = next;
	}
	
	public void add(int n) {
		LinkedList now = this;
		
		do {
			now = now.next;
		} while(now.next != this);
		
		now.next = new LinkedList(n, this);
	}
	
	public int remove() {
		LinkedList now = this;
		LinkedList prev = null;
		
		do {
			prev = now;
			now = now.next;
		} while(now.next != this);
		
		int n = now.num;
		prev.next = now.next;
		
		return n;
	}
}