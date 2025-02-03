import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 가장 멀리 있는거 먼저
        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(deliveries[i] != 0) 
                stack1.push(new int[] {i, deliveries[i]});
            
            if(pickups[i] != 0) 
                stack2.push(new int[] {i, pickups[i]});
        }
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int cap1 = cap;
            int cap2 = cap;
            
            if(!stack1.isEmpty() && !stack2.isEmpty()){ // 가장 먼 곳 까지 
                answer += (stack1.peek()[0] > stack2.peek()[0] ? stack1.peek()[0] + 1 : stack2.peek()[0] + 1) * 2;
            } else if(!stack1.isEmpty() && stack2.isEmpty()) {
                answer += (stack1.peek()[0] + 1) * 2;
            } else {
                answer += (stack2.peek()[0] + 1) * 2;
            }
            
            while(cap1 > 0 && !stack1.isEmpty()){
                int[] top = stack1.pop();
                if(cap1 >= top[1]) {
                    cap1 -= top[1];
                } else {
                    top[1] -= cap1;
                    cap1 = 0;
                    stack1.push(top);
                }
            }
            
            while(cap2 > 0 && !stack2.isEmpty()){
                int[] top = stack2.pop();
                if(cap2 >= top[1]) {
                    cap2 -= top[1];
                } else {
                    top[1] -= cap2;
                    cap2 = 0;
                    stack2.push(top);
                }
            }
        }
        
        return answer;
    }
}