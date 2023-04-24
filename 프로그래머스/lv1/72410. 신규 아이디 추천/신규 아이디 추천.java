import java.util.Stack;

class Programmers {
    public static void main(String[] args) {
       String str = "=.=";
       
       System.out.print(Solution.solution(str));
    }
}

class Solution {
    public static String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 소문자로 치환
        
        for(int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            
            if(c < 'a' || c > 'z') { // 현재 문자가 소문자가 아니고
                if(c < '0' || c > '9') { // 숫자가 아니며
                    if(c != '-' && c != '_' && c != '.') { // 제시된 특수문자가 아닐 때
                        // 해당 문자를 공백으로 치환, 이후 글자 위치가 한 칸씩 앞당겨짐.
                        // 현재 인덱스 재탐색을 위해 i값 감소
                        answer = answer.replace(Character.toString(c), ""); 
                        i--;
                    }
                }
            }
        }
        
        // ".."가 존재하는 동안 ".."를 "."로 치환
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        if(answer.charAt(0) == '.') 
            answer = answer.substring(1);
        if(answer.isEmpty())
            answer = "a";
        
        if(answer.charAt(answer.length() - 1) == '.') 
            answer = answer.substring(0, answer.length() - 1);
        if(answer.isEmpty())
            answer = "a";
        
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            if(answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);
        }
        
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);    
        }
        
        return answer;
    }
}