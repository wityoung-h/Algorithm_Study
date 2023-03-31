import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = br.readLine().split(" ");
    	Integer[] line = new Integer[3];
    	int result = 0;
    	
    	line[0] = Integer.parseInt(str[0]);
    	line[1] = Integer.parseInt(str[1]);
    	line[2] = Integer.parseInt(str[2]);
    	
    	Arrays.sort(line, Collections.reverseOrder());
    	
    	int sum = line[1] + line[2];
    	
    	if(line[0] < sum) {
    		// 주어진 기본 막대가 삼각형 결정 조건을 만족하면 막대를 줄이지 않는다
    		result = sum + line[0];
    	} else {
    		result = sum * 2 - 1;// 가장 긴 막대가 다른 두 막대의 길이보다 1만큼 작을 때 최대
    	}

    	System.out.print(result);
    	
    	br.close();
    }

}
