class Solution {
    // 횟수 : 겹치는 횟수
    // 시작시간까지 횟수 - 종료시간까지 횟수
    // 분침은 1시간(한바퀴)에 59번 겹침
    // 시침은 12시간(한바퀴)에 719번 겹침
    public int timeToSecondConverter(int h, int m, int s){
        return s + m*60 + h*60*60;
    }
    
    public int getHourAlarm(int time){
        return time * 59 / 3600 ;
    }
    
    public int getMinAlarm(int time){
        return time * 719 / 43200;    
    }
    
    public int getCount(int time){
        int penalty = 43200 <= time ? 2 : 1;
        return getHourAlarm(time) + getMinAlarm(time) - penalty;
    }
    
    // 정각이면 겹치고 시작
    public int nowCheck(int time){
        if(time % 3600 == 0) return 1;
        return 0;
    }
    
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int time = timeToSecondConverter(h1,m1,s1);
        int time2 = timeToSecondConverter(h2,m2,s2);
        answer = 
            getCount(time2) - getCount(time) + nowCheck(time);
        System.out.println(answer);
        return answer;
    }
    
   
}