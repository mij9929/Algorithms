import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int endDay = timelogs[0].length;
        int employNums = schedules.length;
        
        boolean[] result = new boolean[schedules.length];
        Arrays.fill(result, true);
        
        for(int time=0; time<endDay; time++) {
            int toDay = (time + startday - 1) % 7 + 1;
            if(toDay == 6 || toDay == 7) continue;
            
            for(int i=0; i<employNums; i++) {
                if(!result[i]) continue;
                if(!isSafe(schedules[i], timelogs[i][time])) {
                    result[i] = false;
                }
            }
            
        }
        
        
        for(int i=0; i<result.length; i++) {
            if(result[i]) answer++;
        }
        
        return answer;
    }
    
    private boolean isSafe(int wantTime, int realTime) {
        int wantTimePlus10 = wantTime + 10;
        if(wantTimePlus10 % 100 >= 60) {
            wantTimePlus10 = ((wantTimePlus10 / 100) + 1) * 100 + (wantTimePlus10 % 100 - 60);
        }        
        if(realTime <= wantTimePlus10) return true;
        else return false;
    }
}