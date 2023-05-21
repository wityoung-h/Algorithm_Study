import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int T = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();
       
       for(int i = 0; i < T; i++) {
    	   String cal = br.readLine();
    	   
    	   int n = Integer.parseInt(br.readLine());
    	   String tmp = br.readLine();
    	   String[] arr_str = tmp.substring(1, tmp.length()- 1).split(",");
    	   
    	   // 숫자를 deque에 넣음
    	   Deque numbers = new ArrayDeque<Integer>();
    	       	   
    	   for(int j = 0; j < n; j++) {
    		   numbers.addLast(Integer.parseInt(arr_str[j]));
    	   }
    	   
    	   sb.append(result(numbers, cal)).append("\n");
       }
       
       
       System.out.print(sb);
       
       br.close();
    }
     
   // Deque와 연산 내용을 넣으면 연산 결과를 return하는 함수
   public static String result(Deque<Integer> deque, String cal) {
	   StringBuilder sb = new StringBuilder();
	   
	   Boolean searchFromFront = true; // 탐색 방향을 결정할 플래그
	   Boolean isError = false; // 에러를 탐지할 플래그
	   
	   for(int i = 0; i < cal.length(); i++) {
		   char type = cal.charAt(i);
		   
		   if(type == 'R') { // R함수(=방향을 뒤집어야 하면)
			   searchFromFront = (searchFromFront) ? false : true; // 탐색 방향 플래그의 값을 변경
		   } else { // D함수
			   if(deque.isEmpty()) { // 빈 deque에서 D를 수행하면 즉시 중단
				   isError = true;
				   break;
			   } else {
				   if(searchFromFront) { // 앞에서부터 탐색
					   deque.pollFirst();
				   } else { // 뒤에서부터 탐색 (역전됐으면)
					   deque.pollLast();
				   }
			   }
			   
		   }
	   }
	   
	   if(isError) { // 
		   sb.append("error");
	   } else {
		   sb.append('[');
		   
		   if(searchFromFront) {   
			   while(!deque.isEmpty()) {
				   sb.append(deque.pollFirst()).append(',');
			   }
		   } else {
			   while(!deque.isEmpty()) {
				   sb.append(deque.pollLast()).append(',');
			   }
		   }
		   
		   if(sb.length() != 1) {
			   // 마지막 ',' 제거
			   // sb.length() != 1 조건에서만 수행하는 경우? deque에 남아 있는 수가 없는 경우엔 "["만 들어있기 때문
			   sb.deleteCharAt(sb.length() - 1); 
		   }
		   
		   sb.append(']');
	   }
	   
	   
	   return sb.toString();
   }
}

