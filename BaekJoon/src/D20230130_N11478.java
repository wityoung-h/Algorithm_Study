import java.io.*;
import java.util.HashMap;

public class D20230130_N11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		
		// 문자열을 저장할 HashMap : 중복 검사가 필요하므로 HashMap을 사용함
		HashMap map = new HashMap<String, Boolean>();
		
		// i : 문자열의 길이 1 ~ len, j : 자를 문자열의 시작 인덱스
		// 문자열의 길이가 i인 문자열은 (len - i + 1)개 발생한다.
		// ex) len = 5, i = 1 : 문자열 5개, i = 2 : 문자열 4개, ..., i = 5 : 문자열 1개 
		for(int i = 1; i <= len; i++) {
			for(int j = 0; j <= len - i; j++) {
				map.put(str.substring(j, j + i), false);
			}
		}		
		
		System.out.print(Integer.toString(map.size()));
		
		br.close();
	}
}
