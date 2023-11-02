import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	Queue<Integer> list = new LinkedList();
    	
    	StringBuilder sb = new StringBuilder();
    	int lastNumber = 0;
    	
    	for(int i = 0; i < N; i++) {
    		String str = br.readLine();
    		
    		if(str.contains("push")) {
    			String[] arr = str.split(" "); 
    			list.add(Integer.parseInt(arr[1]));
    			lastNumber = Integer.parseInt(arr[1]);
    		} else if(str.contains("pop")) {
    			if(list.isEmpty()) {
    				sb.append("-1\n");
    			} else {
    				sb.append(list.poll() + "\n");
    			}
    		} else if(str.contains("size")) {
    			sb.append(list.size() + "\n");
    		} else if(str.contains("empty")) {
    			if(list.isEmpty()) {
    				sb.append("1\n");
    			} else {
    				sb.append("0\n");
    			}
    		} else if(str.contains("front")) {
    			if(list.isEmpty()) {
    				sb.append("-1\n");
    			} else {
    				sb.append(list.peek() + "\n");
    			}
    		} else {
    			if(list.isEmpty()) {
    				sb.append("-1\n");
    			} else {
    				sb.append(lastNumber + "\n");
    			}
    		}
    	}
    	
    	System.out.println(sb);

    	br.close();
    }
    
    
}

