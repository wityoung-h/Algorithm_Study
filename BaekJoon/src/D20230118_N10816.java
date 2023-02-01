import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D20230118_N10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//HashMap 생성 key = 숫자 카드에 적혀있는 수, value = 숫자카드의 개수
		HashMap map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
		// HashMap 입력. key가 존재하는지를 확인하고 존재하지 않는 경우 개수를 1, 존재하는 경우 기존 value + 1
		for(int i = 0; i < N; i++) {
			Integer temp = Integer.parseInt(st.nextToken());
			int count = 1;
			
			if(map.get(temp) != null) 
				count = (int) map.get(temp) + 1;
			
			map.put(temp, count);
		}
		
		int M = Integer.parseInt(br.readLine());
		String str2 = br.readLine();
		st = new StringTokenizer(str2, " ");
		StringBuilder sb = new StringBuilder();
		
		// HashMap에서 입력된 값을 갖는 key가 있으면 그 개수를, 없다면 0을 반환
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int count = 0;
			
			if(map.get(temp) != null)
				count = (int) map.get(temp);
			
			sb.append(count + " ");
		}
		
		System.out.print(sb);
		br.close();
	}
}
