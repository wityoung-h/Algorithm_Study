import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Comparator;


class Solution {
    public int[] solution(String s) {
        HashMap map = new HashMap<String, Integer>();
	        
	        String[] strs = s.split(",");
	        
	        for(int i = 0; i < strs.length; i++) {
	        	if(strs[i].lastIndexOf("{") != -1) {
	        		strs[i] = strs[i].substring(strs[i].lastIndexOf("{") + 1);
	        	}
	        	
	        	if (strs[i].indexOf("}") != -1) {
	        		strs[i] = strs[i].substring(0, strs[i].indexOf("}"));
	        	}
	        	
	        	if(map.containsKey(strs[i])) {
	        		map.put(strs[i], (int) map.get(strs[i]) + 1);
	        	} else {
	        		map.put(strs[i], 1);
	        	}
	        }
	        
	        
	        int[] answer = new int[map.size()];
	        int[][] list = new int[map.size()][2];
	        int j = 0;
	        
	        Iterator<String> iter = map.keySet().iterator();
	        
	        while(iter.hasNext()) {
	        	String str = iter.next();
	        	list[j][0] = Integer.parseInt(str);
	        	list[j++][1] = (int) map.get(str);
	        }
	        
	        Arrays.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1];
				}
	        });
	        
	        for(int i = 0; i < map.size(); i++) {
	        	answer[i] = list[i][0];
	        }
	        
	        return answer;
    }
}