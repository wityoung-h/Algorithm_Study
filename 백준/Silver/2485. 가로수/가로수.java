import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       int[] tree = new int[N]; // 가로수가 심어져 있는 위치 저장
       int[] gap = new int[N - 1]; // 각 가로수 간 간격 저장
       
       for(int i = 0; i < N; i++) {
    	   tree[i] = sc.nextInt();
    	   
    	   if(i != 0) {
    		   gap[i - 1] = tree[i] - tree[i - 1];
    	   }
       }
       // 가로수 간 간격들의 최소 공배수
       int gcd = gap[0];
       
       for(int i = 1; i < N - 1; i++) {
    	   gcd = GCD(gcd, gap[i]);
       }
        
       int count = 0;
       
        // j : tree배열을 제어할 변수,
        // i : for문 반복시 gcd씩 더해줄 변수
       for(int i = gcd, j = 0; j < N - 1; i += gcd) {
    	   if(tree[0] + i == tree[j + 1]) {
    		   j++; // 현재 위치에 이미 가로수가 있는 경우 j 증가
    	   } else {
    		   count++; // 현재 위치에 가로수가 없으면 심어야 함
    	   }
       }
       
       System.out.print(count);
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