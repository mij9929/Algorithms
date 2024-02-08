import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int len = words.length;
        Stack<String> stack = new Stack<>();
        stack.push(words[0]);
        for(int i=1; i<len; i++){
            if(stack.contains(words[i])){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
            
            String tmp = stack.peek();
            if(tmp.charAt(tmp.length()-1) != words[i].charAt(0)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
                
            stack.push(words[i]);
        }
        
        return answer;
    }
}