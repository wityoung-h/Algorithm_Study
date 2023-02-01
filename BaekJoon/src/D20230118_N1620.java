import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D20230118_N1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 숫자 키를 갖는 해시맵, 스트링 키를 갖는 해시맵
		HashMap numMap = new HashMap<Integer, String>();
		HashMap strMap = new HashMap<String, Integer>();
		
		// 해시맵에 데이터 입력
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			numMap.put(i, name);
			strMap.put(name, i);
		}
		
		//BufferedWriter 쓰는 경우
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			
			// 읽어들인 값이 대문자로 시작하는 경우 strMap, 아닌 경우 numMap 서치
			if (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z')
				bw.write(strMap.get(line).toString() + "\n");
			else {
				String name = (String) numMap.get(Integer.parseInt(line));
				bw.write(name + "\n");
			}
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
