class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        answer = len;
        
        for(int i = 1; i <= len; i++) {
            String temp = "";
            
            String sub = s.substring(0, i);
            int cnt = 1;
            
            for(int j = i; j < len; j += i) {
            	String temp2;
            	
            	if(j + i > len - 1) {
                    temp2 = s.substring(j);
                } else {
                	temp2 = s.substring(j, j + i);
                }
                
                if(temp2.equals(sub)) {
                    cnt++;
                } else {
                    if(cnt == 1) 
                        temp += sub;
                    else
                        temp += (Integer.toString(cnt) + sub);
                    sub = temp2;
                    cnt = 1;
                }
            }
            temp += (cnt == 1) ? "" : cnt;
            temp += sub;
            
            int n = temp.length();
            answer = (n < answer) ? n : answer;
        }
        
        return answer;
    }
}