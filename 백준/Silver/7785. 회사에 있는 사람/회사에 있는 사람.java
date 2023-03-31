import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	HashMap list = new HashMap<String, Boolean>();
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i< n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		String name = st.nextToken(); String state = st.nextToken();
    		
    		if(state.equals("leave")) {
    			list.remove(name);
    		} else {
    			list.put(name, true);
    		}
    	}
    	
    	ArrayList keyList = new ArrayList<String>(list.keySet());
    	Collections.sort(keyList, Collections.reverseOrder());
    	
    	keyList.forEach((name) -> {
    		System.out.print(name + "\n");
    	});
    			
    	br.close();
    }

}
