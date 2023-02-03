import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class D20230203_N1004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
				
		StringBuilder sb = new StringBuilder();
		
		for(int j = 0; j < T; j++) {
			String[] point = br.readLine().split(" ");

			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				String[] planet = str.split(" ");
				
				// 입력된 행성계 하나를 통과하는지 테스트하는 함수
				boolean through = isThrough(point, planet); 
				
				if(through) // 통과한다면 count증가
					count += 1;
			}
			
			sb.append(count + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static boolean isThrough(String[] point, String[] planet) {
		// 하나의 행성계를 필수로 진입/이탈 하는 경우?
		// 출발점(도착점)이 행성계 내부에 존재하고 도착점(출발점)이 행성계 외부에 존재할 때

		int x1 = Integer.parseInt(point[0]); int y1 = Integer.parseInt(point[1]);
		int x2 = Integer.parseInt(point[2]); int y2 = Integer.parseInt(point[3]);
		int cx = Integer.parseInt(planet[0]); int cy = Integer.parseInt(planet[1]);
		int r = Integer.parseInt(planet[2]);
		
		// d1 : 출발점과 행성계 중심 사이의 거리, d2 : 도착점과 행성계 중심 사이의 거리
		double d1 = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
		double d2 = Math.sqrt(Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2));
		
		// 출발점 및 도착점 모두가 행성계 내부에 있을 경우 행성계를 통과하지 않음
		if(d1 <= r && d2 <= r)
			return false;
		else if(d1 < r || d2 < r) // 출발점과 도착점 중 하나만 행성계 내부에 있을 경우 행성계를 통과함
			return true;
		
		// 출발점과 도착점 모두 행성계 외부에 있을 경우 행성계를 통과하지 않음
		return false;
	}
}
