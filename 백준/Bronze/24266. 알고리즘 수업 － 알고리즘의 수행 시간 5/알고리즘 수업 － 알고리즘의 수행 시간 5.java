import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        // 총 실행 횟수 : n^3
        System.out.print( ((long)n) * n * n + "\n" + 3);
        
        sc.close();
    }
}