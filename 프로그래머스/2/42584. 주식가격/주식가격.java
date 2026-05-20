import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            int current = i; 
            while(true) {
                if(stack.isEmpty()) break;
                if(prices[current] < prices[stack.peek()]) {
                    answer[stack.peek()] = current - stack.peek();
                    stack.pop();
                }
                else break;
            }
            
            stack.push(current);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = len - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;
    }
}