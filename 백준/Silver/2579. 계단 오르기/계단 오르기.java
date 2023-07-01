import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] points = new int[n]; 
        
        for(int i = 0; i < n; i++) {
        	points[i] = Integer.parseInt(br.readLine());
        }
        
        if(n == 1) {
        	System.out.print(points[0]);
        } else {
        	int[][] arr = new int[n][2]; // bottom-up 구조, 각 계단에서의 최댓값을 저장할 변수
            // 이차원 배열인 이유? 연속된 계단일 때, 건너뛴 계단일 때의 값들을 저장 
            // arr[i][0] : 직전 계단 점수와의 합, arr[i][1] : 2계단 위의 점수와의 합
           
            // 가장 높은 계단 : 자체값 
            arr[n - 1][1] = points[n - 1];
            arr[n - 2][0] = points[n - 1] + points[n - 2];
            
            for(int i = n - 3; i >= 0; i--) {
            	arr[i][0] = points[i];
            	arr[i][1] = points[i];
            	
            	arr[i][0] += arr[i + 1][1]; // 직전 계단 값을 더함. 단, 직전 계단은 두 계단 건너뛴 상태여야 함.
            	
            	if(i + 2 < n) {
            		arr[i][1] += Math.max(arr[i + 2][0], arr[i + 2][1]); // 두 계단 전 값을 더함. 이전 계단의 상태는 영향을 끼치지 않음.
            	}
            }
            
            // 첫 계단의 값들을 비교, 이후 두번째 계단의 연속 계단 값과 비교. (두번째 계단의 연속 계단인 경우, 첫번째 계단을 밟지 않게 됨)
            System.out.print(Math.max(Math.max(arr[0][0], arr[0][1]), arr[1][0]));
        }
        br.close();
    }
}