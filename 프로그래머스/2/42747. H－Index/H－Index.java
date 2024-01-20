import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i=len; i>0; i--){
            if(citations[len-i] >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}