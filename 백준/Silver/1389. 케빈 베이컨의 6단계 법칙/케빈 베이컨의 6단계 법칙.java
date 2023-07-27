import java.io.*;

class Main {
	public static int[][] bacons;
	public static int[] sums;
	final static int INF = 987654321;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] tmp = br.readLine().split(" ");
    	
    	int N = Integer.parseInt(tmp[0]);
    	int M = Integer.parseInt(tmp[1]);
    	
    	bacons = new int[N][N];
    	
    	for(int i = 0; i < M; i++){
    		tmp = br.readLine().split(" ");
    		
    		bacons[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = 1;
    		bacons[Integer.parseInt(tmp[1]) - 1][Integer.parseInt(tmp[0]) - 1] = 1;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(bacons[i][j] == 0) {
    				bacons[i][j] = INF;
    			}
    		}
    	}
    	
    	for(int k = 0; k < N; k++) { // 노드 k를 거치는 경우
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < N; j++) {
    				if(bacons[i][k] + bacons[k][j] < bacons[i][j]) {
    					bacons[i][j] = bacons[i][k] + bacons[k][j];
    				}
    			}
    		}
    	}
    	
    	int index = -1;
    	int min = Integer.MAX_VALUE;
    	
		for(int i = 0; i < N; i++) {
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				sum += bacons[i][j];
			}
			
			if(min > sum) {
				index = i;
				min = sum;
			}
		}
	
		System.out.print(index + 1);
		
    	br.close();
    }
    

}

