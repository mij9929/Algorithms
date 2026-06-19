import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        students[0] = 0;
        
        for(int i=0; i<lost.length; i++) {
            int num = lost[i];
            students[num]--;
        }
        
        for(int i=0; i<reserve.length; i++) {
            int num = reserve[i];
            students[num] ++;
        }

        for(int i=1; i<=n; i++) {
            if(students[i] == 1) continue;
            
            if(students[i] == 0) {
                if(i-1 > 0 &&students[i-1] > 1 ) {
                    students[i-1] --;
                    students[i] ++;
                }
                
                else if(i+1 <= n && students[i+1] > 1) {
                    students[i+1] --;
                    students[i] ++;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            if(students[i] >= 1) answer++;
        }
        
        return answer;
    }
}