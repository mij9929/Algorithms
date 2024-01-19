import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 2차원 공간 
        int answer = 1;
        int len = targets.length;
        Arrays.sort(targets, (o1, o2) -> { return o1[1] - o2[1];});
                   
        double pos = (double)(targets[0][1])-0.5;
        System.out.println(pos);
        for(int i=1; i<len; i++){
            if((double)targets[i][0] < pos && (double)targets[i][1] > pos) continue;
            answer++;
            pos = (double)targets[i][1] - 0.5;
        }
        return answer;
    }
}