import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int len = score.length;
        int count = len/m;
        int start = len%m;
        for(int i=0; i<count; i++){
            int idx = i*m + start;
            answer += score[idx]*m;
        }
        return answer;
    }
}