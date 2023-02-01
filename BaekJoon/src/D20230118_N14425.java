import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class D20230118_N14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap map = new HashMap<String, Boolean>();
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			map.put(temp, true);
		}
		
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			if(map.get(temp) != null)
				count++;
		}
		
		System.out.print(count);
		
		br.close();
	}
}
