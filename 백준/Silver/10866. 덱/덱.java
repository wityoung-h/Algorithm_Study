import java.io.*;
import java.util.ArrayList;

class Main {
	public static ArrayList<Integer> deque = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       
       int N = Integer.parseInt(br.readLine());
       
       for(int i = 0; i < N; i++) {
    	   String[] tmp = br.readLine().split(" ");
    	   
    	   if(tmp[0].contains("push_front")) {
    		   push_front(Integer.parseInt(tmp[1]));
    	   } else if(tmp[0].contains("push_back")) {
    		   push_back(Integer.parseInt(tmp[1]));
    	   } else if(tmp[0].contains("pop_front")) {
    		   sb.append(pop_front()).append("\n");
    	   } else if(tmp[0].contains("pop_back")) {
    		   sb.append(pop_back()).append("\n");
    	   } else if(tmp[0].contains("front")) {
    		   sb.append(front()).append("\n");
    	   } else if(tmp[0].contains("back")) {
    		   sb.append(back()).append("\n");
    	   } else if(tmp[0].contains("size")) {
    		   sb.append(size()).append("\n");
    	   } else {
    		   sb.append(empty()).append("\n");
    	   }
       }
       
       System.out.print(sb);
       
       br.close();
    }
     
    public static void push_front(int n) {
		deque.add(0, n);
	}
	
	public static void push_back(int n) {
		deque.add(n);
	}
	
	public static int pop_front() {
		if(deque.size() == 0)
			return -1;
		
		return deque.remove(0);
	}
	
	public static int pop_back() {
		if(deque.size() == 0)
			return -1;
		
		return deque.remove(deque.size() - 1);
	}
	
	public static int front() {
		if(deque.size() == 0)
			return -1;
		
		return deque.get(0);
	}
	
	public static int back() {
		if(deque.size() == 0)
			return -1;
		
		return deque.get(deque.size() - 1);
	}
	
	public static int size() {
		return deque.size();
	}
	
	public static int empty() {
		if(deque.size() == 0)
			return 1;
		else
			return 0;
	}
}

