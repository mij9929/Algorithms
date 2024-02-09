import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(String name) {
        int answer = 0;        
        int len = name.length();
        ArrayList<Integer> wrongWords = new ArrayList<>();
        for(int i=0; i<len; i++){
            int b = (int)name.charAt(i) - 'A';
            if(b>0){
                wrongWords.add((i));
                answer += Math.min(b, Math.abs(26-b));
            }
        }

        int wrongCount = wrongWords.size();
        if(wrongCount == 0) return 0;
        
        int target = wrongWords.get(wrongCount-1);
        if(target > len - wrongWords.get(0)) target = len - wrongWords.get(0);
        for(int i=0; i<wrongCount-1; i++){
            int tmp = wrongWords.get(i) + (len - wrongWords.get(i+1) + wrongWords.get(i));
            target = Math.min(target, tmp); // 오른쪽으로 먼저 이동 후 왼쪽으로
            tmp = (len - wrongWords.get(i+1))*2 + wrongWords.get(i);
            target = Math.min(target, tmp); // 왼쪽으로 먼저 이동 후 오른쪽으로
            
        }
        
        answer += target;
        return answer; 
    }
}