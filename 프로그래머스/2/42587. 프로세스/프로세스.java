import java.util.*;

class Solution {
    static class Process{
        public int priority;
        public int idx;
        
        public Process(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            Process p = new Process(priorities[i], i);
            pq.add(priorities[i]);
            q.add(p);
        }
        
        int answer = 1;
        while(true){
            Process p = q.poll();
            if(pq.peek() <= p.priority){
                pq.poll();
                if(p.idx == location)
                    break;
                answer++;
            }
            else{
                q.add(p);
            }
            
        }
    
        
        return answer;
    }
}