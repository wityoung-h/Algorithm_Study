import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class D20230201_N4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList lists = new ArrayList<String>();
		
		while(true) {
			String tmp = br.readLine();
			String result;
			
			if(tmp.equals("0 0 0")) break;
			
			StringTokenizer st = new StringTokenizer(tmp, " ");
			double[] numPow = new double[3];
			
			for(int i = 0; i < 3; i++) {
				int a = Integer.parseInt(st.nextToken());
				numPow[i] = Math.pow(a, 2);
			}
			
			if(numPow[0] == numPow[1] + numPow[2]) result = "right";
			else if (numPow[1] == numPow[0] + numPow[2]) result = "right";
			else if (numPow[2] == numPow[0] + numPow[1]) result = "right";
			else result = "wrong";
			
			lists.add(result);
		}
		
		StringBuilder sb = new StringBuilder();
		
		lists.forEach((result) -> {	sb.append(result + "\n");});
		
		System.out.print(sb);
		
		br.close();
	}
}
