import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
    	int d = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());
    	int x = -1000, y = -1000;
    	for(int i = -999; i <= 999; i++) {
    		for(int j = -999; j <= 999; j++) {
    			if((a * i + b *j) == c && (d * i + e * j) == f) {
    				x = i; y = j;
    				break;
    			}
    			if (x == i)
    				break;
    		}
    	}
    			
    	System.out.print(x + " " + y);
    			
    	br.close();
    }

}
