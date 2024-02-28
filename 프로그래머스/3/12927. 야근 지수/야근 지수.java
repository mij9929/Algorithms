import java.util.*;
import java.lang.Math;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n && !pq.isEmpty(); i++){
            int work = pq.poll();
            if(work > 0) {
                work--;
                pq.add(work);
            }
        }
        
        
        while(!pq.isEmpty()){
            int work = pq.poll();
            answer += (long) Math.pow(work, 2);
        }
        
        return answer;
    }
}