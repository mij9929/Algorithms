import java.util.*;

class Solution {
    static class Truck{
        public int weight;
        public int startTime;
        
        public Truck(int weight, int startTime){
            this.weight = weight;
            this.startTime = startTime;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckLen = truck_weights.length;
        Queue<Truck> q = new LinkedList<>();
        int idx = 0;
        int currentWeight = 0;
        int waitCount = 0;
        while(waitCount < truckLen){
            answer++;
            if(!q.isEmpty() && answer - q.peek().startTime == bridge_length){
                currentWeight -= q.poll().weight;
                waitCount++;
            }
            
            if(idx < truckLen){
                if(q.size() <= bridge_length && currentWeight + truck_weights[idx] <= weight){
                    Truck t = new Truck(truck_weights[idx], answer);
                    q.add(t);
                    currentWeight += truck_weights[idx];
                    idx++;
                }
            }
            
            
            
            
        }
        
        return answer;
    }
}