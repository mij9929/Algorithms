class Solution {
    // 0시 00분 00초에서 23시 59분 59초까지 2852번 겹침
    // 0시 00분 00초에서 11시 59분 59초까지 2426번?
    public int timeToSecondConverter(int h, int m, int s){
        return s + m*60 + h*60*60;
    }
    
    public int getHourAlarm(int time){
        return time * 59 / 3600 ;
    }
    
    public int getMinAlarm(int time){
        return time * 719 / 43200;    
    }
    
    private boolean alramNow(int time) {
        return time * 719 % 43200 == 0 || time * 59 % 3600 == 0;
    }
    
    public int getCount(int time){
        int penalty = 43200 <= time ? 2 : 1;
        return getHourAlarm(time) + getMinAlarm(time) - penalty;
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int time = timeToSecondConverter(h1,m1,s1);
        int time2 = timeToSecondConverter(h2,m2,s2);
        answer = 
            getCount(time2) - getCount(time) + (alramNow(time) ? 1 : 0);
        System.out.println(answer);
        return answer;
    }
    
   
}