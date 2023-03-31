import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    	int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		minX = (x < minX) ? x : minX;
    		maxX = (x > maxX) ? x : maxX;
    		minY = (y < minY) ? y : minY;
    		maxY = (y > maxY) ? y : maxY;
    	}
    	
    	System.out.print((maxX - minX) * (maxY - minY));
    	
    	br.close();
    }

}
