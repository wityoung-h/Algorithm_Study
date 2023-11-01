import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		String str = br.readLine();
    		boolean isPalindrome = true;
    		
    		if(str.equals("0")) {
    			System.out.print(sb);
    			break;
    		}
    	
    		int lastIndex = str.length() - 1;
    	
    		for(int i = 0; i <= lastIndex / 2 - 1; i++) {
    			if(!isSame(str, i, lastIndex)) {
    				isPalindrome = false;
    				break;
    			}
    		}
    		
    		if(lastIndex % 2 != 0) {
    			if(!isSame(str, lastIndex / 2, lastIndex)) {
    				isPalindrome = false;
    			}
    		}
    		
    		if(isPalindrome) {
    			sb.append("yes\n");
    		} else {
    			sb.append("no\n");
    		}
    		
    		
    	}
    	
    	br.close();
    }
    
    public static boolean isSame(String str, int nowIndex, int lastIndex) {
		char c1 = str.charAt(nowIndex);
		char c2 = str.charAt(lastIndex - nowIndex);
	
		if(c1 != c2) {
			return false;
		} else {
			return true;
		}
    }
}

