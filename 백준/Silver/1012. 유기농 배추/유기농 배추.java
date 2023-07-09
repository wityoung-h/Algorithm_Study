import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
        	// tmp[0] : 가로 길이, tmp[1] : 세로 길이, tmp[2] : 배추 개수 
        	String[] tmp = br.readLine().split(" ");

        	int[][] field = new int[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])];
        	
        	for(int j = 0; j < Integer.parseInt(tmp[2]); j++) {
        		String[] coordinate = br.readLine().split(" ");
        		
        		field[Integer.parseInt(coordinate[0])][Integer.parseInt(coordinate[1])] = 1;
        	}
        	
        	sb.append(countWorm(field) + "\n");

        }
        System.out.print(sb);
        br.close();
    }
    
    public static int countWorm(int[][] field) {
    	int count = 0;
    	
    	for(int i = 0; i < field.length; i++) {
    		for(int j = 0; j < field[0].length; j++) {
    			if(field[i][j] == 1) {
    				count++;
    				setWorm(field, i, j);
    			}
    		}
    	}
    	
    	return count;
    }
    
    public static void setWorm(int[][] field, int i, int j) {
    	if(i < 0 || i > field.length - 1 || j < 0 || j > field[0].length - 1) {
    		return ;
    	}
    	
    	if(field[i][j] == 1) {
    		field[i][j] = 2;
    		
    		setWorm(field, i - 1, j);
    		setWorm(field, i + 1, j);
    		setWorm(field, i, j - 1);
    		setWorm(field, i, j + 1);
    	}
    }
}
