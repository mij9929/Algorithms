import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder(Long.toString(n));
        String num = sb.reverse().toString();
        answer = new int[sb.length()];
        for(int i=0 ;i<num.length(); i++){
            answer[i] = num.charAt(i) - '0';
        }
        
        return answer;
    }
}