import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> gemsSet = new HashSet<>();
        int len = gems.length;
        
        for(int i=0; i<len; i++) {
            gemsSet.add(gems[i]);
        }
        
        int totalGemsCount = gemsSet.size();


        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int answerStart = 0;
        int answerEnd = len-1;
        int minAnswer = len;
        
        for(int right=0; right<len; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while(map.size() == totalGemsCount) {
                int currentLength = right - left + 1;
                
                if(currentLength < minAnswer) {
                    minAnswer = currentLength;
                    answerStart = left;
                    answerEnd = right;
                }
                
                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);
                
                if(map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }
                
                left++;
            }
        }
        
        
        return new int[] {answerStart+1, answerEnd+1};
    }
}