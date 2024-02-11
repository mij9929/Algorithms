import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<len; i++){
            if(pq.size()<k){
                pq.add(enemy[i]);
            }
            else{
                if(pq.peek() < enemy[i]){
                    n -= pq.poll();
                    pq.add(enemy[i]);
                }
                else
                    n -= enemy[i];
            }
            
            if(n < 0) break;
            
            answer++;
        }
        
        
        return answer;
    }
}