import java.util.*;
import java.lang.Math;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int idx = 0;
        for(int i=0; i<len-k; i++){
            char max = 0;
            for(int j = idx; j <= i+k; j++){
                if(number.charAt(j) > max){
                    max = number.charAt(j);
                    idx = j+1;
                }
                if(max == '9') break;
                
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}