import java.io.*;

class Main {
	public static long arr[] = new long[101];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine()); 
    		
    		sb.append(count(N) + "\n");
    	}
    	
    	System.out.print(sb);
    	br.close();
    }
    
    public static long count(int N) {
    	if(arr[N] != 0) {
    		return arr[N];
    	}
    	
    	switch(N) {
    	case 1:
    	case 2:
    	case 3:
    		return arr[N] = 1;
    	case 4:
    	case 5:
    		return arr[N] = 2;
    	}
    	
    	return arr[N] = count(N - 1) + count(N - 5);
    }
}