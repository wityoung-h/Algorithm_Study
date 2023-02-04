import java.io.*;
import java.lang.StringBuilder;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			String[] strs = str.split(" ");
			int[] num = new int[2];
			num[0] = Integer.parseInt(strs[0]); num[1] = Integer.parseInt(strs[1]);
			
			int max = num[0] - num[1] > 0 ? num[0] : num[1];
			int min = num[0] - num[1] > 0 ? num[1] : num[0];
			
			while(true) {
				int r = max % min;
				
				if(r == 0) {
					sb.append(num[0] * num[1] / min + "\n");
					break;
				}
				
				max = min;
				min = r;
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
 