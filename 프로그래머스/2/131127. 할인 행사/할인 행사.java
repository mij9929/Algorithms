import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> discountHashMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            hashMap.put(want[i], number[i]);        
        }
        
        for(int i=0; i<discount.length; i++) {
            discountHashMap.put(discount[i], discountHashMap.getOrDefault(discount[i], 0) + 1);
            
            if(i < 9) continue;
            
            if(hashMap.equals(discountHashMap))
                answer ++;
            
            discountHashMap.put(discount[i-9], discountHashMap.get(discount[i-9])-1);
            
            if(discountHashMap.get(discount[i-9]) == 0) 
                discountHashMap.remove(discount[i-9]);
            
        }
        
        
        
        return answer;
    }
}