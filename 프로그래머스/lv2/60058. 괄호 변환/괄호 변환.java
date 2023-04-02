import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = makeRight(p);

        return answer;
    }
    
    public String makeRight(String s) {
        if(s.equals("")) //빈 문자열의 경우 바로 반환
            return s;
        
        String result = "";
        String u = "", v = "";
        
        // 균형잡힌 괄호 문자열 두 개로 나누기
        // 단, u는 더 이상 쪼갤 수 없는 균형잡힌 괄호 문자열이어야 하므로 index 2부터 고려
        for(int i = 2; i <= s.length(); i += 2) {
            if(isBalance(s.substring(0, i)) && isBalance(s.substring(i))) {
                u = s.substring(0, i);
                v = s.substring(i);
                break;
            }
        }
        
        if(isRight(u)) {
            result += u;
            result += makeRight(v);
        } else {
            result = "(";
            result += makeRight(v);
            result += ")";
            
            for(int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(')
                    result += ')';
                else
                    result += '(';
            }
        }
        
        return result;
    }
    
    // 균형잡힌 문자열인지 확인하는 함수
    public boolean isBalance(String s) {
        int countL = 0;
        int countR = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                countL++;
            else
                countR++;
        }
        
        if(countL == countR) //단순 개수 비교
            return true;
        else 
            return false;
    }
    
    // 옳은 문자열인지 확인하는 함수, stack 사용
    public boolean isRight(String s) {
        if(s.length() % 2 != 0)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                st.push(c);
            } else {
                if(st.empty())
                    return false;
                else
                    st.pop();
            }
        }
        
        return true;
    }
}