import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.StringBuilder;

public class Main {
	static long[][] memo = new long[30][15];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	// 의상의 종류 및 개수를 저장할 HashMap
        	HashMap map = new HashMap<String, Integer>();
        	
        	for(int j = 0; j < n; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		st.nextToken();
        		String type = st.nextToken(); // 의상의 종류
        		
        		// 동일한 종류의 의상이 존재한다면 
        		if(map.containsKey(type)) { // 기존의 개수에서 수량을 증가 
        			map.replace(type, (int) map.get(type) + 1);
        		} else {
        			// 입력된 종류의 이상이 없다면 key value 생성
        			map.put(type, 1);
        		}
        	}
        	
        	int ans = 1;
        	boolean flag = false;
        	
        	Iterator iter = map.values().iterator();
        	
        	while(iter.hasNext()) {
        		int cnt = (int) iter.next();
        		
        		if(map.size() == 1) {
        			// 종류가 하나 뿐인 경우, 입지 않는 경우는 존재하지 않음
        			ans *= cnt;
        			break;
        		} else {
        			// 종류가 하나 이상인 경우, 입지 않는 경우도 존재하므로, 옷의 개수 + 1
        			ans *= (cnt + 1);
        		}
        	}
        	
        	// 종류가 하나 이상일 때, 모든 종류를 입지 않는 경우를 제외
        	if(map.size() != 1)
        		ans--;
        	
        	sb.append(ans + "\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}