import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
	        int len = prices.length;
	        int[] answer = new int[len];
	        
	        Stack st = new Stack<Integer>();
	        
	        for(int i = 0; i < len; i++) {
	        	if(st.isEmpty()) {
	            	st.push(i);
	        	} else {
	        		while(prices[i] < prices[(int) st.peek()]) {
	        			int index = (int) st.pop();
	        			answer[index] = i - index;
	        			
	        			if(st.isEmpty())
	        				break;
	        		}
	        		st.push(i);
	        	}
	        }
	        
	        while(!st.isEmpty()) {
	        	int index = (int) st.pop();
	        	answer[index] = (len - 1) - index; 
	        }
     
	        return answer;
	    }
}