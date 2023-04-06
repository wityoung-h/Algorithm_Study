import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static boolean[] prime;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[T];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < T; i++) {
        	int n = Integer.parseInt(br.readLine());
        	nums[i] = n;
        	max = (max < n) ? n : max;
        }
        
        prime = new boolean[max]; // max값에 대한 배열 생성
        Arrays.fill(prime, true); // true로 초기화 
        prime[0] = false; prime[1] = false;
        
        for(int i = 2; i < max; i++) {
    		if(prime[i]) {	// i가 소수이면 그 배수들은 소수가 아님.
    			for(int j = 2; i * j < max; j++) {
    				prime[i * j] = false;
        		} 
    		}
    	}
        
        for(int i = 0; i < T; i++ ) {
        	sb.append(countPartition(nums[i])).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
    
    //골드바흐 파티션의 개수를 세는 함수 
    public static int countPartition(int n) {
    	int count = 0;
    	HashSet<Integer> counted = new HashSet<Integer>();
    	
    	for(int i = 2; i < n; i++) {
    		if(prime[i]) { // i가 소수이고 
    			if(prime[n - i]) { // n - i가 소수이며 
    				if(!counted.contains(n - i)) { // n - i를 이전에 체크하지 않았다면 
    					count++; // count 증가 
    					counted.add(i); // i값을 체크했음 저장
    				}
    			}
    		}
    	}
    	
    	return count;
    }
}