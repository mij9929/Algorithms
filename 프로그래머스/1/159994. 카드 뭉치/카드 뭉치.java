import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> card1 = new ArrayDeque<>();
        Deque<String> card2 = new ArrayDeque<>();
        
        for(String s: cards1) card1.offer(s);
        for(String s: cards2) card2.offer(s);
        
        int idx = 0;
        while(!card1.isEmpty() || !card2.isEmpty()) {
            if(idx == goal.length) break;

            if(!card1.isEmpty() && card1.peekFirst().equals(goal[idx])) {
                card1.poll();
                idx++;
                continue;
            }
            
            else if(!card2.isEmpty() && card2.peekFirst().equals(goal[idx])) {
                idx++;
                card2.poll();
                continue;
            }

            return "No";
        }
        
        
        return "Yes";
    }
}