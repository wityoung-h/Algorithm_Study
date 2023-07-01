import java.io.*;

public class Main {
	public static int[] min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        min = new int[N + 1];
        
        System.out.print(minCal(N));
        
        br.close();
    }
    
    public static int minCal(int n) {
    	if(n == 1) {
    		return 0;
    	}
    	
    	if(min[n] == 0) {
    		int temp = Integer.MAX_VALUE;
    		
    		if(n % 3 == 0) {
    			temp = minCal(n / 3) + 1;
    		}
    		
    		if(n % 2 == 0) {
    			temp = Math.min(minCal(n / 2) + 1, temp);
    		}
    		
    		temp = Math.min(minCal(n - 1) + 1, temp);
    		
    		return min[n] = temp;
    	} else {
    		return min[n];
    	}
    }
}