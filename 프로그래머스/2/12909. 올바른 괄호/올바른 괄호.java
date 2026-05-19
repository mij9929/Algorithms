import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            if(c == ')') {
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}