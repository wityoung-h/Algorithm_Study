import java.io.*;

class Main {
	public static char[] origin;
	
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
        
       while(true) {
    	   String tmp = br.readLine();
    	   
    	   if(tmp == null) {
    		   break;
    	   }
    	   
    	   int N = Integer.parseInt(tmp);
           int len = (int) Math.pow(3, N);
           
           // char 배열을 쓴 이유? String은 replace 중간 값을 바꿀 수 없기 때문
           // 값을 바꾸려면 매번 새로운 String을 만들어야 해 메모리 초과 발생
           origin = new char[len];
           
           for(int i = 0; i < len; i++) {
        	   origin[(int) i] = '-';
           }
           
           cantor(0, len);
           
           sb.append(String.valueOf(origin)).append("\n");
       }
       
       System.out.print(sb);       
       br.close();
    }
    
    public static void cantor(int start, int end) {    	
    	if(end - start == 1) {
    		return ;
    	}
    	    	
    	int trisect = (end - start) / 3;
    	
    	// 3등분에서 중간 부분을 공백으로 바꿈
    	for(int i = start + trisect; i < end - trisect; i++) {
    		origin[i] = ' ';
    	}
    	
    	// 앞 뒤 부분은 재귀처리
    	cantor(start, start + trisect);
    	cantor(end - trisect, end);
    }
     
}

