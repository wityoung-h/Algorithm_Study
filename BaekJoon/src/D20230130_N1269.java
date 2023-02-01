import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

public class D20230130_N1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// mapA는 집합 A의 모든 원소를 key로 가짐
		// mapB는 집합 B의 모든 원소를 key로 가짐
		HashMap mapA = new HashMap<Integer, Boolean>();
		HashMap mapB = new HashMap<Integer, Boolean>();
		
		put(mapA, br.readLine());
		put(mapB, br.readLine());
		
		// 대칭 차집합을 저장할 ArrayList
		// 대칭 차집합이므로 원소의 중복을 걱정할 필요가 없다.
		ArrayList list = new ArrayList<Integer>();
		
		// key가 집합 B에 존재하지 않으면(= 집합 A에만 존재하면) list에 값 추가
		mapA.forEach((key, value) -> {
			if(mapB.get(key) == null) list.add(key);
		});
		
		// key가 집합 A에 존재하지 않으면(= 집합 B에만 존재하면) list에 값 추가
		mapB.forEach((key, value) -> {
			if(mapA.get(key) == null) list.add(key);
		});
		
		System.out.print(Integer.toString(list.size()));
		
		br.close();
	}
	
	public static void put(HashMap map, String str) {
		// str을 " " 단위로 잘라 map에 값을 추가하는 함수
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()) {
			map.put(Integer.parseInt(st.nextToken()), false);
		}
	}
}
