import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
              
       System.out.print((int)(Math.pow(n, 2)) - n);
       
       br.close();
    }
   
}