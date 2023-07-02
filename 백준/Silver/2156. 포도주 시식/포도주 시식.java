import java.io.*;

public class Main {
	public static int[] wine;
	public static Integer[] max_wine;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        wine = new int[N];
        max_wine = new Integer[N];
        
        for(int i = 0; i < N; i++) {
        	wine[i] = Integer.parseInt(br.readLine());
        }
         
        System.out.print(recursion(N - 1));	
        
        br.close();
    }
    
    public static int recursion(int order) {
    	if(max_wine[order] == null) {
    		if(order == 0) {
    			return max_wine[0] = wine[0];
    		} else if(order == 1) {
    			return max_wine[1] = wine[0] + wine[1];
    		} else if(order == 2) {
    			return max_wine[2] = Math.max(Math.max(wine[1] + wine[2], wine[0] + wine[2]), recursion(1));
    		} else {
    			max_wine[order] = Math.max(Math.max(recursion(order - 2), recursion(order - 3) + wine[order - 1]) + wine[order], recursion(order - 1));
    		}
    	}
    	
    	return max_wine[order];
    }
}