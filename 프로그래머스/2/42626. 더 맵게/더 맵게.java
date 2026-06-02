import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s: scoville) {
            pq.offer(s);
        }
                
        while(pq.size() > 1 && pq.peek().intValue() < K ) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int s3 = s1 + (s2 * 2);
            pq.offer(s3);
            answer++;
        }
        
        if(pq.isEmpty() || pq.peek().intValue() < K) return -1;
        
        return answer;
    }
}