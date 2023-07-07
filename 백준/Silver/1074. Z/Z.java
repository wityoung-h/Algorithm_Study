import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String[] temp = br.readLine().split(" ");
    	
    	int N = Integer.parseInt(temp[0]);
    	int r = Integer.parseInt(temp[1]);
    	int c = Integer.parseInt(temp[2]);
    	
    	System.out.print(findOrder(N, r, c));
    	
    	br.close();
    }
    
    public static int findOrder(int N, int r, int c) {
    	if(N == 1) {
    		if(r == 0) {
    			if(c == 0)
    				return 0;
    			else
    				return 1;
    		} else {
    			if(c == 0)
    				return 2;
    			else
    				return 3;
    		}
    	}
    	
    	int order = 0;
    	int half = (int) Math.pow(2, N - 1); // 2^N-1 의 값 == 2^N의 절반
    	if(half > r) {
    		if(half > c) { // r, c가 4등분 중 좌측 상단에 위치
    			order += findOrder(N - 1, r, c);
    		} else { // r, c가 4등분 중 우측 상단에 위치
    			order += half * half; // 좌측 상단에 대한 순서값
    			order += findOrder(N - 1, r, c - half);
    		}
    	} else { 
    		if(Math.pow(2, N - 1) > c) { // r, c가 4등분 중 좌측 하단에 위치
    			order += half * half * 2; // 좌측 상단, 우측 상단에 대한 순서값 
    			order += findOrder(N - 1, r - half, c);
    		} else { // r, c가 4등분 중 우측 하단에 위치
    			order += half * half * 3; // 좌측 상단, 우측 상단, 좌측 하단에 대한 순서값
    			order += findOrder(N - 1, r - half, c - half);
    		}
    	}
    	
    	return order;
    }
}

