import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       
       int n = Integer.parseInt(br.readLine());
       
       for(int i = 0; i < n; i++) {
    	   for(int j = n; j > i + 1; j--) {
    		   sb.append(" ");
    	   }
    	   
    	   for(int j = 0; j < i + 1; j++) {
    		   sb.append("*");
    	   }
    	   sb.append("\n");
       }
       
       System.out.print(sb);
       
       br.close();
    }
}