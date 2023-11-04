import java.io.*;
import java.util.Arrays;


class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] scores = new int[N];
    	int sum = 0;
    	
    	for(int i = 0; i < N; i++) {
    		scores[i] = Integer.parseInt(br.readLine());
    		sum += scores[i];
    	}
    	
    	Arrays.sort(scores);
    	
    	int except = Math.round(N * 0.15f);
    	
    	for(int i = 0; i < except; i++) {
    		sum -= (scores[i] + scores[N - 1 - i]);
    	}
    	
    	System.out.print(Math.round(sum / ((float) N - 2 * except)));
    	
    	br.close();
    }
}

