import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class D20230203_N1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] array = new int[6];
			
			for(int j = 0; j < 6; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			
			int result = count(array); // 두 원의 접점 개수를 return하는 함수
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static int count(int[] array) {
		// 두 좌표 사이의 거리 d
		double d = Math.sqrt(Math.pow(array[0] - array[3], 2) + Math.pow(array[1] - array[4], 2));
		
		// 거리가 0인 경우
		if(d == 0) {
			int result;
			// 반지름이 같다면 동일한 원을 의미, 접점이 무수히 많음 
			if(array[2] == array[5])
				result = -1;
			else // 반지름이 같지 않다면 두 원은 만나지 않음
				result = 0;
			
			return result;
		}
		
		// 두 좌표 사이의 거리가 원의 반지름보다 작은 경우
		if(d < array[2] || d < array[5]) {
			int sub = Math.abs(array[2] - array[5]);
			int result;
			
			if(d < sub) // 반지름의 차보다 d가 작으면 한 원이 다른 원을 포함함, 만나지 않음
				result = 0;
			else if(d == sub) // 반지름의 차와 d가 동일하면 두 원은 내접함
				result = 1;
			else // 반지름의 차보다 d가 크면 두 원은 두 점에서 만남
				result = 2;
			
			return result;
		}
			
		int sum = array[2] + array[5];
		int result;
		
		if(d < sum) // 반지름의 합보다 d가 작으면 두 원은 두 점에서 만남
			result = 2;
		else if(d == sum) // 반지름의 합과 d가 동일하면 두 원은 외접함
			result = 1;
		else // 반지름의 합보다 d가 크면 두 원은 만나지 않음
			result = 0;
		
		return result;
	}
}
