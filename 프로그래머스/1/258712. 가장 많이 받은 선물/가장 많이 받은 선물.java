import java.util.*;

class Solution {
    
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> giftTable = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        
        for(String friend : friends){
            Map<String, Integer> data = new HashMap<>();
            for(int i=0; i<friends.length; i++){
                if(friends[i].equals(friend)) continue;
                data.put(friends[i], 0);
            }
            
            giftTable.put(friend, data);
            giftScore.put(friend, 0);
        }
        
        
        for(String gift: gifts){
            String[] split = gift.split(" ");
            String sender = split[0];
            String receiver = split[1];
            
            giftScore.put(sender, giftScore.getOrDefault(sender, 0) + 1);
            giftScore.put(receiver, giftScore.getOrDefault(receiver, 0) - 1);
            
            Map<String, Integer> data = giftTable.get(sender);
            data.put(receiver, data.getOrDefault(receiver, 0) + 1);
        }

        for(String friend : friends){
            int giftCount = 0;
            Map<String, Integer> data = giftTable.get(friend);
            
            for(int i=0; i<friends.length; i++){
                if(friends[i].equals(friend)) continue;
                int senderCount = data.get(friends[i]);// A -> B 선물 개수
                int receiverCount = giftTable.get(friends[i]).get(friend); // B -> A 선물 개수
                
                if(senderCount > receiverCount) giftCount ++;
                else if(senderCount == receiverCount){
                    if(giftScore.get(friend) > giftScore.get(friends[i])) giftCount++;      
                }
            }
            
            answer = Math.max(answer, giftCount);
        }
        
        
        
        
        return answer;
    }
}