import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] A = new int[N]; 
    			
    	String[] strA = br.readLine().split(" ");
    	
    	for(int i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(strA[i]);
    	}
    	
    	Arrays.sort(A);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int M = Integer.parseInt(br.readLine());
    	String[] nums = br.readLine().split(" ");
    	
    	for(int i = 0; i < M; i++) {
    		if(Arrays.binarySearch(A, Integer.parseInt(nums[i])) >= 0) {
    			sb.append("1\n");
    		} else {
    			sb.append("0\n");
    		}
    	}
    	
    	System.out.print(sb);

    	br.close();
    }
    
}

