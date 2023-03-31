import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder result = new StringBuilder();
    	
    	while(true) {
    		String temp = br.readLine();
    		
    		if(temp.equals("0 0 0")) {
    			break;
    		}
    		
    		StringTokenizer st = new StringTokenizer(temp, " ");
    		int max = 0; // 가장 긴 변의 인덱스를 저장할 변수
    		int[] len = new int[3];
    		
    		for(int i = 0; i < 3; i++) {
    			len[i] = Integer.parseInt(st.nextToken());
    			max = (len[i] > len[max]) ? i : max;
    		}
    		
    		int sum = 0;
    		boolean isEql = false; // 정삼각형을 판별할 flag
    		boolean isIso = false; // 이등변 삼각형을 판별할 flag
    		
    		switch(max) {
    			case 0:
    				sum = len[1] + len[2];
    				
    				if(len[max] == len[1] || len[max] == len[2]) {
    					isIso = true; // len[max]를 포함, 두 변의 길이가 동일
    					isEql = (len[1] == len[2]) ? true : false; // 세 변의 길이가 모두 같다면 정삼각형
    				} else {
    					isIso = (len[1] == len[2]) ? true : false; // len[max]를 포함하지 않고 두 변의 길이가 동일 
    				}
    				
    				break;
    			case 1:
    				sum = len[2] + len[0];
    				
    				if(len[max] == len[2] || len[max] == len[0]) {
    					isIso = true;
    					isEql = (len[2] == len[0]) ? true : false;
    				} else {
    					isIso = (len[2] == len[0]) ? true : false;
    				}
    				
    				break;
    			case 2:
					sum = len[0] + len[1];
					
    				if(len[max] == len[0] || len[max] == len[1]) {
    					isIso = true;
    					isEql = (len[0] == len[1]) ? true : false;
    				} else {
    					isIso = (len[0] == len[1]) ? true : false;

    				}
    				
    				break;
    		}
    		
    		if(isEql)
    			result.append("Equilateral");
    		else if(sum > len[max]) {
    			if(isIso) 
    				result.append("Isosceles");
    			else
    				result.append("Scalene");
    		}
    		else
    			result.append("Invalid");
    		
    		result.append("\n");
    	}
    	
    	System.out.print(result);
    	
    	br.close();
    }

}
