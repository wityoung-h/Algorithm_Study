import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        
        // 5 * 2 = 10
        // N!를 소인수분해하면, 2는 최소 N/2 + a (짝수의 개수 + a)만큼 존재하므로, 항상 5보다 많음
        // 즉, 0의 개수를 결정하는 것은 5의 개수
        
        // 5부터 N보다 작은 5의 배수들이 각각 5의 몇 제곱인지를 구하는 로직
        for(int i = 5; i <= N; i+= 5) {	
        	int tmp = i;
        	
        	// 더이상 5로 나누어 떨어지지 않을 때까지 나누어줌
        	while (tmp % 5 == 0){	
        		cnt++;
        		tmp /= 5;
        	}
        };
        
        System.out.print(cnt);
        
        br.close();
    }
    
}