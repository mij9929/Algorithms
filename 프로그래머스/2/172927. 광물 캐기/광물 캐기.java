import java.util.*;

class Group {
    public int point; // 점수
    // public int priority; // 우선 순위
    public int count; // 광물 갯수
    public int idx;
}

class Solution {    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksCount = picks[0] + picks[1] + picks[2];
        int[] pickPoint = new int[picksCount];
    
        Group[] group = new Group[picksCount];
        
        for(int i=0; i<picksCount; i++){
            int idx = i*5;
            int point = 0;
            int count = 0;
            group[i] = new Group();
            for(int j = idx; j < idx+5 && j<minerals.length; j++){
                if(minerals[j].equals("diamond")) point+=25;
                else if(minerals[j].equals("iron")) point+=5;
                else point+=1;
                count++;
            }
            group[i].point = point;
            group[i].count = count;
            group[i].idx = idx;
        }
        
        for(int i=0; i<picksCount; i++){
            for(int j=0; j<i; j++){
                if(group[i].point > group[j].point){
                    Group tmp = new Group();
                    tmp = group[i];
                    group[i] = group[j];
                    group[j] = tmp;
                }
            }
        }
  
        int pickIdx = 0;
    
        for(int i=0; i<picksCount; i++){
            if(group[i].point == 0) break;
            int idx = group[i].idx; 
            while(picks[pickIdx] < 1) pickIdx++;

            for(int j=idx; j<idx+group[i].count; j++){
                
                 if(pickIdx == 0){
                     answer += 1;
                 }
                else if(pickIdx == 1){
                    if(minerals[j].equals("diamond")) answer += 5;
                    else answer += 1;
                }
                else{
                    if(minerals[j].equals("diamond")) answer += 25;
                    else if(minerals[j].equals("iron")) answer += 5;
                    else answer+=1;
                }
                System.out.println(answer);
            }
            picks[pickIdx]--;
        }
        
        return answer;
    }
}