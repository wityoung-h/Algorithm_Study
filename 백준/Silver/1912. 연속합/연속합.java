import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static int arr[];
	public static Integer dp[];
	public static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	arr = new int[n]; dp = new Integer[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp[0] = arr[0];
    	Max(n - 1);
    	
    	System.out.print(max);
    	br.close();
    }
    
    public static int Max(int N) {
    	if(dp[N] == null) {
    		dp[N] = Math.max(Max(N - 1) + arr[N], arr[N]);
    	}
    	max = Math.max(dp[N], max);
    	return dp[N];
    }
}