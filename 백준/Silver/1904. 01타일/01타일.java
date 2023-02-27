import java.io.*;

class Main {
	public static int arr[] = new int[1000001];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	System.out.print(count(N));
    	
    	br.close();
    }
    
    public static int count(int N) {
    	if(arr[N] != 0) {
    		return arr[N];
    	}
    	
    	if(N == 1)
    		return 1;
    	
    	if(N == 2)
    		return 2;
    	
    	return arr[N] = (count(N - 1) + count(N - 2)) % 15746;
    }
}