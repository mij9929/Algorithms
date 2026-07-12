import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<t*m; i++) {
            String c = Integer.toString(i, n).toUpperCase();
            sb.append(c);
        }
        
        String numbers = sb.toString();
        int len = numbers.length();
        
        for(int i=0; i<len; i++) {
            if(i%m + 1 == p) answer.append(numbers.charAt(i));
            if(answer.length() == t) break;
        }
        
        return answer.toString();
    }
}