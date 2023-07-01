import java.io.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] nm = br.readLine().split(" ");
       
       int N = Integer.parseInt(nm[0]);
       int M = Integer.parseInt(nm[1]);
       
       // 단어 및 빈도를 저장할 HashMap
       HashMap<String, Integer> voca = new HashMap<String, Integer>();
              
       for(int i = 0; i < N; i++) {
    	   String tmp = br.readLine();
    	   
    	   if(tmp.length() < M) { // M보다 짧은 단어는 건너 뛰기
    		   continue;
    	   }
    	   
    	   if(voca.containsKey(tmp)) {
    		   voca.put(tmp, voca.get(tmp) + 1);
    	   } else {
    		   voca.put(tmp, 1);
    	   }
       }
       
       // voca HashMap의 entrySet을 저장할 ArrayList
       ArrayList<HashMap.Entry<String, Integer>> list = new ArrayList<>(voca.entrySet());
       Collections.sort(list, new vocaComp()); // ArrayList를 Comparator를 통해 정렬
       
       StringBuilder sb = new StringBuilder();
       
       // 정렬된 list를 iterator를 통해 출력
       Iterator iter = list.iterator();
       while(iter.hasNext()) {
    	   sb.append(((HashMap.Entry<String, Integer>) iter.next()).getKey() + "\n");
       }
       
       System.out.print(sb);
       
       br.close();
    }
     
    public static class vocaComp implements Comparator<HashMap.Entry<String, Integer>> {
		public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
			if(o1.getValue() > o2.getValue()) // 1. 빈도가 높을수록 우선 순위
				return -1;
			else if(o1.getValue() < o2.getValue())
				return 1;
			else {
				if(o1.getKey().length() > o2.getKey().length()) // 2. 길이가 길수록 우선 순위 
					return -1;
				else if(o1.getKey().length() < o2.getKey().length()) 
					return 1;
				else { // 3. 사전 오름차순
                    String[] strs = new String[2];
                    strs[0] = o1.getKey();
                    strs[1] = o2.getKey();
                    Arrays.sort(strs);
                    
                    if(strs[0].equals(o1.getKey()))
                        return -1;
                    else
                        return 1;
                }
			}
		}
    }
}
