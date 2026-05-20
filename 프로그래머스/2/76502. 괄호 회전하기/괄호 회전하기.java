import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        for(int i=0; i<len; i++){
            String rotateString = rotate(s, i, len);
            if(isCorrect(rotateString)) {
                answer++;
            }
        }
        return answer;
    }
    
    private String rotate(String s, int start, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            sb.append(s.charAt((start+i)%len));
        }
        return sb.toString();
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == ']' && pop != '[') return false;
                if (c == '}' && pop != '{') return false;
            }
        }    
        
        return stack.isEmpty();
    }
}