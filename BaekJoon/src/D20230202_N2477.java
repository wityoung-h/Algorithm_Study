import java.io.*;
import java.util.StringTokenizer;

public class D20230202_N2477 {
	public final static int EAST = 1;
	public final static int WEST = 2;
	public final static int SOUTH = 3;
	public final static int NORTH = 4;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 1m^2에 자라는 참외의 개수
		
		// 입력값을 저장할 array
		int[][] list = new int[6][2];
				
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int side = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			int[] tmp = new int[2];
			tmp[0] = side; tmp[1] = len;
						
			list[i] = tmp;
		}
		
		// 작은 직사각형의 변의 길이는 중복으로 입력된 값들 중 사잇값에 해당 됨
		// ex) 3 30 / 1 60 / 3 20 / 1 100 변의 길이는 3 - 1 - 3 에서 1의 60, 1 - 3 - 1 에서 3의 20
		// a, b : 사이에 입력된 값의 인덱스를 저장할 변수
		int a = -1, b = -1;
		
		for(int i = 0; i < 6; i++) {
			// ◇-■-◇와 같이 하나를 건너 뛰고 중복 입력된 변을 찾으면 인덱스 값을 저장, break
			if(list[i][0] == list[(i + 2) % 6][0]) {
				a = (i + 1) % 6;
				
				// ■-◇-■-◇로 입력되었는지, ◇-■-◇-■로 입력되었는지 확인
				if(list[(i + 1) % 6][0] == list[(i + 3) % 6][0]) {
					b = (i + 2) % 6;
				} else {
					b = i;
				}
				
				break;
			} else
				continue;
		}
		
		// 넓이 = 큰 직사각형의 넓이 - 작은 직사각형의 넓이 (큰 직사각형 변의 인덱스 : 각각 사이 인덱스 + 3 값)
		long size = list[(a + 3) % 6][1] * list[(b + 3) % 6][1] - list[a][1] * list[b][1];
				
		System.out.print(size * K);
		br.close();
	}
}
