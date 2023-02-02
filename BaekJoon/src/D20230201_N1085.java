import java.io.*;
import java.util.StringTokenizer;

public class D20230201_N1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
		// (x, y) : 현재 나의 위치 / (w, h) : 직사각형의 오른쪽 위 꼭짓점 
		int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken()); int h = Integer.parseInt(st.nextToken());
		
		int min = 0; // 최소거리를 저장할 변수
		
		// 직사각형의 좌측 축까지의 거리 : x, 우측 축까지의 거리 : w - x
		// 두 값 비교 후 min에 최소값 저장
		if(w - x > x) min = x; 
		else min = w - x;
		
		// 직사각형의 상단 축까지의 거리 : h - y, 하단 축까지의 거리 : y
		// 두 값 비교 후 min에 저장된 값과 추가 비교, 최소값 저장
		if(h - y > y) {
			if(y < min) min = y;
		} else {
			if(h - y < min) min = h - y;
		}
		
		System.out.print(min);
		
		br.close();
	}
}
