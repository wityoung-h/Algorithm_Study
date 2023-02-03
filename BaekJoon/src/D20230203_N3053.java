import java.io.*;

public class D20230203_N3053 {
	// 택시 기하학에 따른 원을 평면좌표로 옮겨 보면,
	// 마름모 꼴(◇)을 하고 있고 마름모의 각 대각선이 원의 지름에 해당한다.
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R = Integer.parseInt(br.readLine());
		
		double uRound = R * R * Math.PI;
		double tRound = R * R * 2;
		
		System.out.print(String.format("%.6f", uRound) + "\n" + String.format("%.6f", tRound));
		
		br.close();
	}
}
