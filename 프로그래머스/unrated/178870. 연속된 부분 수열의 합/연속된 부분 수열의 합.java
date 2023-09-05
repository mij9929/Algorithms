import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer = new int[2];
        
        
        int start = 0;
        int end = 0;
        int len = sequence.length;
        int sum = 0;
        
        int sums[] = new int[len+1];
        int answerIndexSub = len+1;
            
        for(int i=0; i<len; i++){
            sums[i+1] = sequence[i] + sums[i];
        }
        
        while(end <= len){
            sum = sums[end] - sums[start];
            if(sum == k  && end - start  < answerIndexSub) {
                answer[0] = start;
                answer[1] = end-1;
                answerIndexSub = end - start ;
                end++;
            }
            else if(sum > k) start++;
            else end++;
            
        }
        
        

        
        return answer;
    }
}