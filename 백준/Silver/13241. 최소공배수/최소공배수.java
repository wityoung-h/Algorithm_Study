import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       long A = sc.nextLong();
       long B = sc.nextLong();
       
       long LCM = A * B / GCD(A, B);
       
       System.out.print(LCM);
       
       sc.close();
    }
    
    public static long GCD(long a, long b) {
    	if(a % b == 0)
    		return b;
        else if(b % a == 0)
    		return a;
        else
        	return GCD(b, a % b);
    }
}