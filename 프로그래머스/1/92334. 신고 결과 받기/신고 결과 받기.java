import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>();
        for(String r : report) {
            reportSet.add(r);
        }
        
        Map<String, Integer> userMap = new HashMap<>(); // User별 Index map
        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], i);
        }
        
        Map<String, Integer> reportCountMap = new HashMap<>(); // User별 신고당한 횟수
        
        for(String r: reportSet) {
            String[] split = r.split(" ");
            
            String receiver = split[1];
            
            reportCountMap.put(receiver, reportCountMap.getOrDefault(receiver, 0) + 1);
        }
        
         
        for(String r: reportSet) {
            String[] split = r.split(" ");
            
            String sender = split[0];
            String receiver = split[1];
            
            if(reportCountMap.get(receiver) >= k) {
                answer[userMap.get(sender)]++;
            }
        }
        
        return answer;
    }
}