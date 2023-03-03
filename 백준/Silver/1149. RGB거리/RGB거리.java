import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static int cost[][];
	public static Integer dp[][];
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	cost = new int[n][3];
    	dp = new Integer[n][3];
    	
    	
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		cost[i][0] = Integer.parseInt(st.nextToken());
    		cost[i][1] = Integer.parseInt(st.nextToken());
    		cost[i][2] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp[0][0] = cost[0][0]; dp[0][1] = cost[0][1]; dp[0][2] = cost[0][2];
    	costSum(n - 1, R); costSum(n - 1, G); costSum(n - 1, B);
    	
    	int min = Math.min(Math.min(dp[n - 1][R], dp[n - 1][G]), dp[n - 1][B]);
    	System.out.print(min);
    	br.close();
    }
    
    public static int costSum(int N, int color) {
    	if(dp[N][color] == null) {
    		int co1 = 0, co2 = 0;
    		
    		switch(color) {
    		case R:
    			co1 = G; co2 = B;
    			break;
    		case G:
    			co1 = B; co2 = R;
    			break;
    		case B:
    			co1 = R; co2 = G;
    			break;
    		}
    		
    		dp[N][color] = Math.min(costSum(N - 1, co1), costSum(N - 1, co2)) + cost[N][color];
    	}
    	
    	return dp[N][color];
    }
}