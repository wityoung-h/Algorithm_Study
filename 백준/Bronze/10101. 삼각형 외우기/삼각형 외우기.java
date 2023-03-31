import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] angle = new int[3];
    	int sum = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		angle[i] = Integer.parseInt(br.readLine());
    		sum += angle[i];
    	}
    	
    	String result = "";
    	
    	if(sum != 180) {
    		result = "Error";
    	} else {
    		if(angle[0] == angle[1] || angle[1] == angle[2] || angle[2] == angle[0])
    			result = (angle[0] == 60) ? "Equilateral" : "Isosceles";
    		else
    			result = "Scalene";
    		
    	}
    	
    	System.out.print(result);
    	
    	br.close();
    }

}
