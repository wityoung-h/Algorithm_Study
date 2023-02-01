import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class D20230130_N1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap map = new HashMap<String, Boolean>();
				
		for(int i = 0; i < N + M; i++) {
			String temp = br.readLine();
			
			// 이미 map에 추가된 이름이라면(=듣도 보도 못한 사람) value를 true로 변경
			if(map.get(temp) != null) map.put(temp, true);
			// 처음 추가된 이름이면 map에 값 추가
			else map.put(temp, false);
		}
	
		// 사전식으로 정렬하기 위한 ArraList
		ArrayList list = new ArrayList<String>();
		
		// forEach를 통해 map 모든 값 조회
		map.forEach((key, value) -> {
			// value가 true이면 듣도 보도 못한 사람, list에 값 추가
			if((boolean) value) {
				list.add(key);
			}
		});
        
		// ArrayList 오름차순 정렬
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
        // ArrayList의 size == 듣도보도 못한 사람의 수
		sb.append(Integer.toString(list.size()) + "\n"); 
		
        // forEach를 통해 list의 모든 값 조회
		list.forEach((name) -> {
			sb.append(name + "\n");
		});
		
		System.out.print(sb);
        br.close();
	}
}