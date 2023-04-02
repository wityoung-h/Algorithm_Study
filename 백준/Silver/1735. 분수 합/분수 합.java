import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int a = sc.nextInt(); int b = sc.nextInt();
       int c = sc.nextInt(); int d = sc.nextInt();
       
       int x = a * d + c * b;
       int y = b * d;
       
       int gcd = GCD(x, y);
       
       x /= gcd;
       y /= gcd;
       
       System.out.print(x + " " + y);
       
       sc.close();
    }
    
    public static int GCD(int a, int b) {
    	if(a % b == 0)
    		return b;
        else if(b % a == 0)
    		return a;
        else
        	return GCD(b, a % b);
    }
}