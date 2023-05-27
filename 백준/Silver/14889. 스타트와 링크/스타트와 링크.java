import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static int[][] power; // 능력치를 저장할 배열
	public static boolean[] pick; // 팀을 어떻게 가를건지 저장할 배열
	public static int n;
	public static int min_gap = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	power = new int[n][n];
    	pick = new boolean[n];
    	
    	StringTokenizer st;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		
    		for(int j = 0; j < n; j++) {
    			power[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	pickMember(0, 0);
       	System.out.print(min_gap);
    	
    	br.close();
    }
    
    public static void pickMember(int nowIndex, int depth) {
    	if(depth == n / 2) {
    		int teamA = 0;
    		int teamB = 0;
    		
    		for(int i = 0; i < n; i++) {
    			for(int j = i + 1; j < n; j++) {
    				if(pick[i] == true && pick[j] == true) {
    					teamA += power[i][j];
    					teamA += power[j][i];
    				} else if(pick[i] == false && pick[j] == false){
    					teamB += power[i][j];
    					teamB += power[j][i];
    				}
    			}
    		}
    		
    		int dif = (int) Math.abs(teamA - teamB);
    		
            if(dif == 0) {
                System.out.print(0);
                System.exit(0);
            }
            
    		min_gap = (min_gap > dif) ? dif : min_gap;
    		
    		return;
    	}
    	
    	for(int i = nowIndex; i < n; i++) {
    		if(!pick[i]) {
    			pick[i] = true;
    			pickMember(i + 1, depth + 1);
    			pick[i] = false;
    		}
    	}
    }
}

