import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       
       int n = Integer.parseInt(br.readLine());
       
       for(int i = 0; i < n; i++) {
    	   long x = Long.parseLong(br.readLine());
    	   sb.append(nextPrime(x) + "\n");
       }
       
       System.out.print(sb);
       
       br.close();
    }
    
    public static long nextPrime(long x) {
    	for(long i = x; ; i++) {
    		if(isPrime(i))
    			return i;
    	}
    }
    
    public static boolean isPrime(long x) {
        if(x == 0 || x == 1)
            return false;
        
    	for(int i = 2; i <= Math.sqrt(x); i++) {
    		if(x % i == 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}