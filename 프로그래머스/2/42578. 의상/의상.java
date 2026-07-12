import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        // 옷 경우의 수 + 선택 안하는 경우(+1)
        for(int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1; // 아무것도 입지 않는 경우(-1)
    }
}