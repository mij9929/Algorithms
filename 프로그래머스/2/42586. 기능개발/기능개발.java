import java.util.*;

class Solution {
    static class Process{
        public int progress;
        public int speed;
        public int idx;
        
        public Process(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
            this.idx = 0;
        }
        
        public void working(){
            this.progress += this.speed;
        }
        
        public void finish(int idx){
            this.idx = idx;   
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();
        Queue<Process> complete = new LinkedList<>();
        int len = progresses.length;
        
        for(int i=0; i<len; i++){
            Process process = new Process(progresses[i], speeds[i]);
            process.working();
            queue.add(process);
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            if(queue.peek().progress >= 100){
                Process completion = queue.remove();
                completion.finish(idx);
                complete.add(completion);
                len--;
                continue;
            }
            idx++;
            for(int i=0; i<len; i++){
                Process process = queue.remove();
                process.working();
                queue.add(process);
            }
            
        }
        
       
        int[] result = new int[100];
        while(!complete.isEmpty()){
            Process completion = complete.remove();
            result[completion.idx]++;
        }
        
        for(int i=0; i<100; i++){
            if(result[i] > 0)
                answer.add(result[i]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}