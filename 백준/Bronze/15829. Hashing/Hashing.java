import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static BigInteger r = new BigInteger("31");
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	String str = br.readLine();
    	BigInteger hash = new BigInteger("0");
    	
    	for(int i = 0; i < N; i++) {
    		char c = str.charAt(i);
    		BigInteger tmp = new BigInteger(Integer.toString(c- 'a' + 1));
    		hash = hash.add(tmp.multiply(r.pow(i)));
    	}    	
    	System.out.print(hash.mod(new BigInteger("1234567891")));

    	br.close();
    }
    
    
}

