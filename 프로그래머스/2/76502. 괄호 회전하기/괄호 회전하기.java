import java.util.*;

class Solution {
    //
    public boolean isValid(String s, int start){
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            char c = s.charAt((i+start)%len);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.pop() != '(') return false;
                else if(c == ']' && stack.pop() != '[') return false;
                else if(c == '}' && stack.pop() != '{') return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
        
    }
    
    public int solution(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(isValid(s, i)) count++; 
        }
        return count;
    }
}