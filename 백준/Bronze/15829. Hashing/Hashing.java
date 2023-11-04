import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	String str = br.readLine();
    	long hash = 0L;
    	
    	for(int i = 0; i < N; i++) {
    		char c = str.charAt(i);
    		hash += (c - 'a' + 1) * Math.pow(31, i) % 1234567891;
    	}
    	
    	System.out.print(hash % 1234567891);

    	br.close();
    }
    
    
}

