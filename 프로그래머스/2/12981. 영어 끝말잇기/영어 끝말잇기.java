import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        int x = 0;
        
        for(String word : words) {
            if(stack.isEmpty()) {
                stack.push(word);          
                x++;
                continue;
            }
            
            int lastIdx = stack.peek().length()-1;
            if(stack.peek().charAt(lastIdx) == word.charAt(0) && !stack.contains(word)) 
                stack.push(word);
            else 
                return new int[]{x%n+1, x/n+1};
            
            x++;
        }
        
        


        return answer;
    }
}