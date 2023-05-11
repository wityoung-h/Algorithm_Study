import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
         String answer = "";
	        
	        HashMap scores = new HashMap<Character, Integer>();
	        scores.put('R', 0); scores.put('T', 0);
	        scores.put('C', 0); scores.put('F', 0);
	        scores.put('J', 0); scores.put('M', 0);
	        scores.put('A', 0); scores.put('N', 0);
	        
	        
	        for(int i = 0; i < survey.length; i++) {
	        	addScore(scores, survey[i], choices[i]);
	        }
	        
	        answer += ((int) scores.get('R') >= (int) scores.get('T')) ? 'R' : 'T';
	        answer += ((int) scores.get('C') >= (int) scores.get('F')) ? 'C' : 'F';
	        answer += ((int) scores.get('J') >= (int) scores.get('M')) ? 'J' : 'M';
	        answer += ((int) scores.get('A') >= (int) scores.get('N')) ? 'A' : 'N';
	        
	        return answer;
    }
    
    public void addScore(HashMap<Character, Integer> scores, String type, int answer) {
	    	if(answer == 4) {
	    		return;
	    	} else if(answer < 4){
	    		int score = 4 - answer;
	    		scores.put(type.charAt(0), score + (int) scores.get(type.charAt(0)));
	    		return;
	    	} else {
	    		int score = answer - 4;
	    		scores.put(type.charAt(1), score + (int) scores.get(type.charAt(1)));
	    		return;
	    	}
	    }
}