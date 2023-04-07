import java.io.*;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       br.readLine(); // 첫번째 줄은 ENTER이므로 건너뜀
       
       HashSet<String> greeted = new HashSet<String>(); //인사한 사람들을 저장할 HashSet
       int count = 0;
              
       for(int i = 1; i < n; i++) {
    	   String nickname = br.readLine();
    	   
    	   if(nickname.equals("ENTER")) {
               // ENTER가 입력되면 저장된 HashSet 초기화 단, count는 초기화하지 않음
    		 greeted.clear();  
    	   } else if(greeted.contains(nickname)) {
    		   continue; // 인사한 기록이 있으면 건너뜀
    	   } else { // 인사한 적이 없으면 count 증가, HashSet에 닉네임 저장
    		   count++;
    		   greeted.add(nickname);
    	   }
       }
       
       System.out.print(count);
       
       br.close();
    }
    
}
