import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.print( ((long)n * (n - 1)) / 2 + "\n" + 2);
        
        sc.close();
    }
}