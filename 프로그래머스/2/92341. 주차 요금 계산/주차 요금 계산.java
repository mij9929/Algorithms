import java.util.*;
import java.lang.Math;

class Solution {
    public int convertMin(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        
        return h * 60 + m;
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> info = new HashMap<>(); // 차량 정보, 시간
        TreeMap<String, Integer> totalFee = new TreeMap<>(); // 번호, 요금 // 키를 오름차순으로 정렬하는 TreeMap
        
        for(String record : records){
            String[] split = record.split(" ");
            int time = convertMin(split[0]);
            if(split[2].equals("IN")){
                info.put(split[1], time);
            }
            else{
                totalFee.put(split[1], totalFee.getOrDefault(split[1], 0) + time - info.get(split[1]));
                info.remove(split[1]);
            }
        }
        
        for(String num : info.keySet()){
            totalFee.put(num, totalFee.getOrDefault(num, 0) + 1439 - info.get(num));
            
        }
        
        int len = totalFee.size();
        answer = new int[len];
        int idx = 0;
        for(String num : totalFee.keySet()){
            if(totalFee.get(num) <= fees[0]) {
                answer[idx++] = fees[1];
            }
            else{
                answer[idx++] = fees[1] + (int)(Math.ceil(((double)(totalFee.get(num) - fees[0]))/fees[2]))*fees[3];
                
            }
        }
        System.out.println(totalFee.toString());
        
        return answer;
    }
}