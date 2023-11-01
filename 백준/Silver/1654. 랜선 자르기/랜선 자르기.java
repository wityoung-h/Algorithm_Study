import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	String[] KNs = str.split(" ");
    	
    	int K = Integer.parseInt(KNs[0]);
    	int N = Integer.parseInt(KNs[1]);
    	
    	int[] lans = new int[K];
    	
    	long max = Integer.MIN_VALUE;
    	long min = 0;
    	
    	for(int i = 0; i < K; i++) {
    		lans[i] = Integer.parseInt(br.readLine());
    		max = (max < lans[i]) ? lans[i] : max; 
    	}

    	max++;
    	long mid = 0;
    	
    	while(max > min) {
    		mid = (max + min) / 2;
    		long cnt = 0;
    		
    		for(int i = 0; i < K; i++) {
    			cnt += (lans[i] / mid);
    		}
    		
    		if(cnt >= N) {
    			min = mid + 1;
    		} else {
    			max = mid;
    		}
    	}
    	
    	System.out.println(min - 1);

    	br.close();
    }
    
}

