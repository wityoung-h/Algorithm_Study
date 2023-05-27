import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int N = Integer.parseInt(br.readLine());
       
       System.out.print(factorial(N));
       
       br.close();
    }
    
    public static long factorial(int n) {
    	if(n == 0) {
    		return 1;
    	} else {
    		return n * factorial(n - 1);
    	}
    }
     
}

