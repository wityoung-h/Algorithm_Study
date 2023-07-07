import java.io.*;

class Main {
	public static int[] countZero = new int[41];
	public static int[] countOne = new int[41];
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	countZero[0] = 1;
    	countOne[1] = 1;
    	
    	int T = Integer.parseInt(br.readLine());

    	for(int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());

    		sb.append(cntZero(N) + " " + cntOne(N) + "\n");
    	}
    	
    	System.out.print(sb);
    	
    	br.close();
    }
    
    public static int cntZero(int N) {
    	if(N >= 2 && countZero[N] == 0) {
    		countZero[N] = cntZero(N - 1) + cntZero(N - 2);
    	}
    	
    	return countZero[N];
    }
    
    public static int cntOne(int N) {
    	if(N >= 2 && countOne[N] == 0) {
    		countOne[N] = cntOne(N - 1) + cntOne(N - 2);
    	}
    	
    	return countOne[N];
    }
}

