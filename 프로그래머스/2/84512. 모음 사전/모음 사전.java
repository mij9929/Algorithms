import java.util.*;

class Solution {
    
    public int solution(String word) {
        int answer = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        
        while(!word.equals(sb.toString())) {
            if(sb.length() < 5) {
                sb.append("A");
            }
            
            else if(sb.charAt(4) != 'U') {
                char c = sb.charAt(4);
                char next = nextChar(c);
                sb.setCharAt(4, next);
            }
            
            else {
                for(int i=4; i>=0; i--) {
                    if(sb.charAt(i) == 'U') {
                        sb.deleteCharAt(i);
                    }
                    else {
                        char c = sb.charAt(i);
                        char next = nextChar(c);
                        sb.setCharAt(i, next);
                        break;
                    }
                }
            }
            
            answer++;
            
        }
        
        return answer;
    }
    
    public char nextChar(char c) {
        if(c == 'A') return 'E';
        if(c == 'E') return 'I';
        if(c == 'I') return 'O';
        else return 'U';
        
    }
              
}