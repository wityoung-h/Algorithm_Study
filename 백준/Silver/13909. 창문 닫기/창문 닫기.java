import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       // x번째 창문은 x의 약수 개수만큼 문이 열리고 닫힘
       // 즉, 약수의 개수가 홀수인 창문만 열림
       // 약수의 개수가 홀수? >> x의 약수 중 x의 제곱근이 존재하는 수
       System.out.print((int) Math.floor(Math.sqrt(n)));
       
       br.close();
    }
   
}