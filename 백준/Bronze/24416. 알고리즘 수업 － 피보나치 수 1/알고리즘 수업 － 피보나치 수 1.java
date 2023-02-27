import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int fib = fib(n);
    	int dynamic = n - 2;
    	
    	System.out.print(fib + " " + dynamic);
    	
    	br.close();
    }
    
    public static int fib(int n) {
    	if(n == 1 || n == 2) {
    		return 1;
    	}
    	
    	return fib(n - 1) + fib(n - 2);
    }
}