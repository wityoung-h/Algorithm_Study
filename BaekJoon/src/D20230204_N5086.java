import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class D20230204_N5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0 0")) break;
			
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String result;
			
			if(b % a == 0) // 첫번째 숫자가 두 번째 숫자의 약수일 때
				result = "factor";
			else if(a % b == 0) // 두 번째 숫자가 첫번째 숫자의 약수일 때
				result = "multiple";
			else // 그 외의 경우
				result = "neither";
			
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
