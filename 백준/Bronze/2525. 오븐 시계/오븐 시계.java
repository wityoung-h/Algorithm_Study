import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        
        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        int cookingTime = Integer.parseInt(br.readLine());
        
        int end_minute = minute + cookingTime;
        
        int end_hour = hour + end_minute / 60;
        end_minute %= 60;
        
        end_hour = (end_hour >= 24) ? (end_hour - 24) : end_hour;
        
        System.out.print(end_hour + " " + end_minute);
        br.close();
    }
}