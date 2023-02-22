import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.print((long) Math.pow(n, 2) + "\n" + 2);
        
        sc.close();
    }
}