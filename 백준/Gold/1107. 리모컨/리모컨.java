import java.io.*;
import java.util.ArrayList;

class Main {
	public static boolean[] broken = new boolean[10]; 
	public static final int INNIT_CHANNEL = 100;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String goal = br.readLine();
    	int goal_int = Integer.parseInt(goal);
    	int M = Integer.parseInt(br.readLine());
    	
    	int answer = Math.abs(goal_int - 100);
    	
    	if(M == 0) {
    		answer = (Math.abs(goal_int - INNIT_CHANNEL) > goal.length()) ? goal.length() : Math.abs(goal_int - INNIT_CHANNEL) ; 
    	} else if(M == 10) {
    		answer = Math.abs(goal_int - INNIT_CHANNEL);
    	} else {
    		String[] temp = br.readLine().split(" ");
    		
    		for(int i = 0; i < M; i++) {
    			broken[Integer.parseInt(temp[i])] = true;
    		}
    		
    		for(int i = 0; i <= 999999; i++) {
    			boolean isbroken = false;
    			
    			String now = String.valueOf(i);
    			
    			for(int j = 0; j < now.length(); j++) {
    				if(broken[now.charAt(j) - '0']) {
    					isbroken = true;
    					break;
    				}
    			}
    			
    			if(!isbroken) {
    				int tmp = Math.abs(i - goal_int) + now.length();
    				answer = Math.min(answer, tmp);
        		}
    		}
    		
    		
    	}
    	
    	System.out.print(answer);
    	
    	br.close();
    }
}

