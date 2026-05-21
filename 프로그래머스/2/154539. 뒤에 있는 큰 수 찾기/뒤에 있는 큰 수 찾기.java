import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++) {
            int current = i;
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[current]) {
                int pop = stack.pop();
                answer[pop] = numbers[current];
            }
            stack.push(current);
        }
        
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = -1;
        }
        
        return answer;
    }
}