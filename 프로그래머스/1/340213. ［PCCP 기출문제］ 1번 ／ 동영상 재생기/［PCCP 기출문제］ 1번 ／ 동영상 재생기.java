import java.util.*;

class Solution {

    
    public int[] timeConvert(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        int[] clock = new int[2];
        clock[0] = hour;
        clock[1] = min;
        return clock;
    }
    
    public int[] calc(int[] time, boolean flag){
        if(flag){ // true => next
            time[1] += 10;
            if(time[1] >=60) {
                time[1]-=60;
                time[0]++;
             }
            
        }
        
        else{
            time[1] -= 10;
            if(time[1] < 0){
                time[1] += 60;
                time[0]--;
            } 
        }
        return time; 
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int[] now = new int[2];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] len = new int[2];
        
        now = timeConvert(pos);
        start = timeConvert(op_start);
        end = timeConvert(op_end);
        len = timeConvert(video_len);
        

        
        for(int i=0; i<commands.length; i++){
            String comm = commands[i];
            if(start[0]*60 + start[1] <= now[0]*60 + now[1] &&
                now[0]*60 + now[1] < end[0]*60 + end[1]){
                now = Arrays.copyOf(end,end.length);
            }
        
            now = calc(now, comm.equals("next"));
            
            if(now[0]*60 + now[1] <= 0){
                now[0] = 0;
                now[1] = 0;
            }
            
            if(now[0]*60 + now[1] > len[0]*60 + len[1]){
                now = Arrays.copyOf(len,len.length);
            }
            
            if((start[0]*60 + start[1] <= now[0]*60 + now[1]) &&
                (now[0]*60 + now[1] < end[0]*60 + end[1])){
                now = Arrays.copyOf(end,end.length);
            }
            System.out.println(Arrays.toString(now));
            
        }
        
        if(start[0]*60 + start[1] <= now[0]*60 + now[1] &&
                now[0]*60 + now[1] < end[0]*60 + end[1]){
                now = Arrays.copyOf(end,end.length);
        }
        
        if(now[0] < 10) answer += "0";
        answer+=now[0];
        answer+=":";
        if(now[1] < 10) answer +="0";
        answer+=now[1];
        
        
        return answer;
    }
}