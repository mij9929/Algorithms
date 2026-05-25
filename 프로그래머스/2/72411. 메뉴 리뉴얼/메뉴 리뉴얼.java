import java.util.*;
import java.lang.Math;
class Solution {
    Map<String, Integer> courseMap = new HashMap<>(); // ex) AB: 2, ACD: 3
    boolean[] visit; // 조합 방문 체크용
    
    public void combination(char[] cook, int start, int depth, int targetLength) { //요리 경우의 수
       if(depth == targetLength) {
           StringBuilder sb = new StringBuilder();
           
           for(int i=0; i<visit.length; i++) {
               if(visit[i]) sb.append(cook[i]);
           }
           
           String key = sb.toString();
           courseMap.put(key, courseMap.getOrDefault(key, 0) + 1);
           return;
       }
        
        for(int i=start; i<cook.length; i++) {
            visit[i] = true;
            combination(cook, i+1, depth+1, targetLength);
            visit[i] = false;
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(String o : orders) {
            char[] cook = o.toCharArray();
            Arrays.sort(cook);

            // 해당 코스 요리로 나올 수 있는 경우의 수 체크
            // ex) ABCFG -> A:1, B:1 ... ABCFG;1
            visit = new boolean[cook.length];
            for(int i=2; i<=cook.length; i++){
                combination(cook, 0, 0, i);
            }
        }
        
        for(int len : course) {
            int max = 0;
            
            for(String key : courseMap.keySet()) {
                String menu = key;
                int count = courseMap.get(key);
                
                if(menu.length() == len && count >=2) {
                    max = Math.max(max, count);
                }
            }
            
            for(String key : courseMap.keySet()) {
                String menu = key;
                int count = courseMap.get(key);
                
                if(menu.length() == len && count == max) {
                    answer.add(menu);
                }
            }
        }
        
        String[] ans = answer.toArray(new String[0]);
        Arrays.sort(ans);
        
        return ans;
    }
}