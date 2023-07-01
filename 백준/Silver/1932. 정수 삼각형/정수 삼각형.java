import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        triangle = new int[n][n]; // 삼각형을 줄 번호, 각 줄의 인덱스를 갖는 2차원 배열로 저장
        
        for(int i = 0; i < n; i++) {
        	String[] nums = br.readLine().split(" "); // 수 분할
            
        	for(int j = 0; j <= i; j++) { // i번째 줄의 j번째 수
        		if(i != 0) {// 첫번째 줄을 제외하고 나머지 줄에서
        			if(j == 0) { // 첫번째 수일 때 : 윗줄의 0번째 수를 가져옴
        				triangle[i][0] += triangle[i - 1][0];
        			} else if(j == i) { // 마지막 수일 때 : 윗줄의 마지막 수를 가져옴
        				triangle[i][j] += triangle[i - 1][j - 1];
        			} else { // j번째 수일 때 윗줄의 j - 1 수와 j 번째 수 중 큰 수를 가져옴
        				triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        			}
        		}
        		triangle[i][j] += Integer.parseInt(nums[j]); // 현재 값 더하기
        	}
        }
        
        int[] last = triangle[n - 1].clone(); // 삼각형의 마지막 줄 가져오기
        
        Arrays.sort(last); //오름차순으로 정렬
        
        System.out.print(last[n - 1]); // 최댓값 출력
        
        br.close();
    }

}