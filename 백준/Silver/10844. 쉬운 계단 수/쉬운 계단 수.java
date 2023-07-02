import java.io.*;

public class Main {
	public static Long[][] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // N자리 자리 수의 마지막 자릿값이 0 ~ 9인 경우를 카운트
        nums = new Long[N + 1][10];
       
        // 한자리 수 초기화
        for(int i = 1; i < 10; i++) {
        	nums[1][i] = (long) 1;
        }
        nums[1][0] = (long) 0;
        
        long sum = 0;
        
        for(int i = 0; i < 10; i++) {
        	sum += stairNum(N, i);
        }
        
        System.out.print(sum % 1000000000);
        
        br.close();
    }
    
    
    // n - 1 자리 계단수로부터 2개의 n자리 계단수를 만들 수 있음
    // ex) 34 -> 343, 345
    // 단, n자리 계단수의 마지막 수가 0인 경우, 9인 경우 이전 자리 수가 무조건 1,8이어야 
    public static long stairNum(int N, int last) { // N : 자리 수
    	if(nums[N][last] == null) {		
    		if(last == 0) {
    			nums[N][last] = stairNum(N - 1, 1);
    		} else if(last == 9) {
    			nums[N][last] = stairNum(N - 1, 8);
    		} else {
    			nums[N][last] = stairNum(N - 1, last - 1) + stairNum(N - 1, last + 1);
    		}
    	}
    	
    	return nums[N][last] % 1000000000;
    }
}