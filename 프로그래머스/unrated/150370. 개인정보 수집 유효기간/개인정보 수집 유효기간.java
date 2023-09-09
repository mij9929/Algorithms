import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int todayConvert = TimeConvert(today);
        int[] temp = new int[privacies.length];
        int size = 0;
        for(int i=0; i<privacies.length; i++){
            String[] pSplit = privacies[i].split(" ");
            String type = pSplit[1];
            for(String t : terms){
                String[] termSplit = t.split(" ");
                if(type.equals(termSplit[0])){
                    if(TimeConvert(pSplit[0]) + Integer.parseInt(termSplit[1])*28 <= todayConvert) {
                        temp[i] = i+1;
                        size++;
                    }
                }
            } 
        }
        
        answer = new int[size];
        int idx = 0;
        for(int i=0; i<temp.length; i++){
            if(temp[i] > 0){
                answer[idx++] = temp[i];
            }
        }
                   
          
                                    
        return answer;
    }
    
    int TimeConvert(String d){
        String[] split = d.split("\\.");
        return Integer.parseInt(split[0])*12*28 + Integer.parseInt(split[1])*28+Integer.parseInt(split[2]);
        
    }
    

}