import java.io.*;
import java.util.ArrayList;

public class Main {
	public static int[] max_len;
	public static int[] arr;
	public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        String[] nums = br.readLine().split(" ");
        arr = new int[N];
        max_len = new int[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(nums[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
        	int tmp = maxLength(i);
        	max = (max > tmp) ?  max : tmp;
        }
        
        System.out.print(max);
        
        br.close();
    }
    
    public static int maxLength(int n) {
    	if(n == N - 1) {
    		return max_len[n] = 1;
    	}
    	
    	if (max_len[n] != 0){
    		return max_len[n];
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int i = n; i < N; i++) {
    		if(arr[n] < arr[i]) {
    			int tmp = maxLength(i);
    			max = (max > tmp) ? max : tmp;
    		}
    	}
    	
    	if(max == Integer.MIN_VALUE) {
    		return max_len[n] = 1;
    	} else {
    		return max_len[n] = max + 1;
    	}
    }
}