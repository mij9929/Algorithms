import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashCompletionMap = new HashMap<>();
        String answer = new String();
        for(String c : completion) {
            hashCompletionMap.put(c, hashCompletionMap.getOrDefault(c, 0) + 1);
        }
        
        for(String p: participant) {
            if(hashCompletionMap.getOrDefault(p, 0) == 0) {
                answer = p;
                return p;
            };
            hashCompletionMap.put(p, hashCompletionMap.getOrDefault(p, 0) - 1);
        }
        
        return answer;
    }
}