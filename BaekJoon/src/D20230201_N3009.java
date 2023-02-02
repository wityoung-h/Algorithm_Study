import java.io.*;

public class D20230201_N3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Point[] points = new Point[3]; // 세 좌표를 저장할 배열
		
		for(int i = 0; i < 3; i++) {
			String str = br.readLine();
			String[] tmp = str.split(" ");
			points[i] = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		
		int x = 0, y = 0; // 정답을 결정할 변수
		
		// 축에 평행한 직사각형이므로 두 꼭짓점끼리 각각 x좌표 값이 같아야 함
		if(points[1].x == points[2].x) x = points[0].x;
		else if(points[0].x == points[2].x) x = points[1].x;
		else x = points[2].x;
		
		// 축에 평행한 직사각형이므로 두 꼭짓점끼리 각각 y좌표 값이 같아야 함
		if(points[1].y == points[2].y) y = points[0].y;
		else if(points[0].y == points[2].y) y = points[1].y;
		else y = points[2].y;
		
		System.out.print(x + " " + y);
		
		br.close();
	}
}

// 좌표 class
class Point {
	int x;
	int y;
	
	public Point(int a, int b) {
		this.x = a;
		this.y = b;
	}
}
