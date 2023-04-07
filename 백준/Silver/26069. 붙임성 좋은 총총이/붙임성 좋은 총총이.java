import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       
       // 춤추는 사람의 명단을 저장할 HashSet
       HashSet<String> dancing = new HashSet<String>();
       
       boolean metChongChong = false; // 총총이가 등장한 적이 있는지를 나타낼 flag
       int count = 0;
              
       for(int i = 0; i < n; i++) {
    	   String temp = br.readLine();
    	   
    	   if(!metChongChong) {
    		   // 총총이가 등장한 적이 없다면
    		   // 현재 str에 ChongChong이 존재하는지를 확인하고 존재하지 않는다면 continue
    		   if(temp.contains("ChongChong")) {
    			   metChongChong = true;
    			   dancing.add("ChongChong");
    		   } else {
    			   continue;
    		   }
    	   }
    	   
    	   StringTokenizer st = new StringTokenizer(temp, " ");
    	   String name1 = st.nextToken(), name2 = st.nextToken();
    	   
    	   // 만난 사람 중 춤추고 있는 사람이 있으면 HashSet에 추가
    	   if(dancing.contains(name1)) {
    		   dancing.add(name2);
    	   } else if(dancing.contains(name2)) {
    		   dancing.add(name1);
    	   } 
       }
       
       System.out.print(dancing.size());
       
       br.close();
    }
    
}
