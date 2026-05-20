import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c) stack.push(c);
            else if(stack.peek() == c) stack.pop();
        }
        
        if(stack.isEmpty()) return 1;
        return 0;
    }
}