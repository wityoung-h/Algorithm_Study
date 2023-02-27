import java.io.*;

class Main {
	public static int[][][] memo = new int[21][21][21];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		String str = br.readLine();
    		if(str.equals("-1 -1 -1")) break;
    		
    		String[] num = str.split(" ");
    		int value = goBack(Integer.parseInt(num[0]), Integer.parseInt(num[1]), Integer.parseInt(num[2]));
    		
    		sb.append(String.format("w(%s, %s, %s) = %d", num[0], num[1], num[2], value) + "\n");
    	}

    	System.out.print(sb);
    	
    	br.close();
    }
    
    public static int goBack(int a, int b, int c) {
    	if(a <= 0 || b <= 0 || c <= 0)
    		return 1;
    	
    	if(a > 20 || b > 20 || c > 20)
    		return goBack(20, 20, 20);
    	
    	if(memo[a][b][c] != 0)
    		return memo[a][b][c];
    	
    	if(a < b && b < c)
    		return memo[a][b][c] = goBack(a, b, c - 1) + goBack(a, b - 1, c- 1) - goBack(a, b - 1, c);
    	
    	return memo[a][b][c] = goBack(a - 1, b, c) + goBack(a - 1, b - 1, c) + goBack(a - 1, b, c - 1) - goBack(a - 1, b - 1, c - 1);
    }
}