class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            if(canSpeakWord(babbling[i]))
                answer++;
        }
        
        return answer;
    }
    
    public boolean canSpeakWord(String str) {
        if(str.length() > 3) {
            String postPrn = "";
            
            for(int i = 0; i < str.length();) {
                String temp = "";
                char now = str.charAt(i);
                
                switch(now) {
                    case 'a':
                    case 'w':
                        if(i > str.length() - 3)
                            temp = str.substring(i);
                        else
                            temp = str.substring(i, i + 3);
                        i += 3;
                        break;
                    case 'y':
                    case 'm':
                        if(i > str.length() - 2)
                            temp = str.substring(i);
                        else
                            temp = str.substring(i, i + 2);
                        i += 2;
                        break;
                    case 'z':
                        i += 1;
                }
                
                if(canSpeak(temp)) {
                    if(postPrn.equals(temp))
                        return false;
                    else {
                        postPrn = temp;
                        continue;
                    }
                }
                return false;
            }
        } else {
            return canSpeak(str);
        }
        
        return true;
    }
    
    public boolean canSpeak(String str) {
        if(str.equals("aya") || str.equals("ye") || str.equals("woo") || str.equals("ma"))
            return true;
        else
            return false;
    }
}