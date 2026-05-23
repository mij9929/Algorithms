import java.util.*;
class Solution {
    public boolean compare(Map<String, Integer> m1, Map<String, Integer>m2){
        if(m1.entrySet().containsAll(m2.entrySet()))
            return true;
        else
            return false;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> list = new HashMap<>();
        Map<String, Integer> dcList = new HashMap<>();
        int n = want.length;
        for(int i=0; i<n; i++){
            list.put(want[i], number[i]);
        }
        for(int i=0; i<10; i++){
            dcList.put(discount[i], dcList.getOrDefault(discount[i],0) + 1);
        }
        
        int idx = 0;
        if(compare(list, dcList)) answer++;  
        for(int i=10; i<discount.length; i++){
            dcList.put(discount[idx], dcList.get(discount[idx])-1);
            dcList.put(discount[i], dcList.getOrDefault(discount[i],0) + 1);
            if(dcList.get(discount[idx]) == 0) dcList.remove(discount[idx]);
            idx++;
            if(compare(list, dcList)) answer++;   
        }
       
        return answer;
    }
}