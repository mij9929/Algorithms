import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int len = plans.length;
        String[] answer = new String[len];
        int idx = 0;
        
        Arrays.sort(plans, new Comparator<String[]>(){// 먼저 오는 과제 순서로 정렬
           @Override
            public int compare(String[] s1, String[] s2){
                return s1[1].compareTo(s2[1]);
            }
        }); 
        
        Stack<String[]> stop = new Stack<String[]>();
        
        for(int i=0; i<len-1; i++){
            int playTime = Integer.parseInt(plans[i][2]);
            int timeGap = TimeGapMinutes(plans[i+1][1], plans[i][1]);
            if(timeGap >= playTime){
                answer[idx++] = plans[i][0];
                timeGap -= playTime;
                while(!stop.isEmpty()){
                    String[] remainPlans = stop.pop();
                    int remainPlayTime = Integer.parseInt(remainPlans[2]);
                    if(remainPlayTime <= timeGap){ // 남은과제를 완료할 수 있으면
                        answer[idx++] = remainPlans[0];
                        timeGap -= remainPlayTime;
                    }
                    else{
                        remainPlans[2] = String.valueOf(remainPlayTime-timeGap);
                        stop.push(remainPlans);
                        break;
                    }
                    
                }
            }
            else{
                playTime -= timeGap;
                plans[i][2] = String.valueOf(playTime);
                stop.push(plans[i]);
            }
        }
        
        answer[idx++] = plans[len-1][0];
        
        while(!stop.isEmpty()){
            answer[idx++] = stop.pop()[0];
        }
        return answer;
    }
    public int TimeGapMinutes(String nextTime, String currentTime){
        int cth = Integer.parseInt(currentTime.substring(0,2));
        int ctm = Integer.parseInt(currentTime.substring(3,5));
        
        int nth = Integer.parseInt(nextTime.substring(0,2));
        int ntm = Integer.parseInt(nextTime.substring(3,5));
        
        int timeGap = 0;
        
        // 시간차 계산
        if(ntm - ctm < 0) {
            timeGap += ntm - ctm + 60;
            nth--;
        }
        else
            timeGap += ntm - ctm;
        
        timeGap += (nth-cth)*60;

        return timeGap;
        
    }

}