import java.util.*;
class MusicInfo {
    String name;
    String melody;
    int playTime;
    int idx;
    
    public MusicInfo(String name, String melody, int playTime, int idx) {
        this.name = name;
        this.melody = melody;
        this.playTime = playTime;
        this.idx = idx;
    }
}
class Solution {
    public String solution(String m, String[] musicinfos) {
        m = melodyBuilder(m);
        PriorityQueue<MusicInfo> pq = new PriorityQueue<>((a,b) -> {
            if(a.playTime != b.playTime) return Integer.compare(b.playTime, a.playTime);
            else return Integer.compare(a.idx, b.idx);
        });
        
        int mLen = m.length();
        for(int i=0; i<musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            int playTime = getPlayTime(musicInfo[0], musicInfo[1]);
            String name = musicInfo[2];
            
            StringBuilder sb = new StringBuilder();
            String originMelody = melodyBuilder(musicInfo[3]);
            int musicLen = originMelody.length();
            for(int j=0; j<playTime; j++) {
                char ch = originMelody.charAt(j%musicLen);
                sb.append(ch);
            }
            String melody = sb.toString();
            
            if(melody.contains(m)) {
                MusicInfo info = new MusicInfo(name, melody, playTime, i);
                pq.offer(info);
            }      
        }
        
        
        if(pq.isEmpty()) return "(None)";
        return pq.poll().name;  
    }
    
    public int getPlayTime(String start, String end) {
        int startHour = Integer.parseInt(start.split(":")[0]);
        int startMin = Integer.parseInt(start.split(":")[1]);
        
        int endHour = Integer.parseInt(end.split(":")[0]);
        int endMin = Integer.parseInt(end.split(":")[1]);
        
        int playTimeHour = 0;
        int playTimeMin = 0;
        
        if(endMin < startMin) {
            endHour -=1;
            endMin+=60;
        } 
        
        playTimeHour = endHour - startHour;
        playTimeMin = endMin - startMin;
        
        return playTimeHour*60 + playTimeMin;
    }
    
    String melodyBuilder(String origin) {
        StringBuilder sb = new StringBuilder();
        int len = origin.length();
        for(int i=0; i<len; i++) {
            if(i+1 < len && origin.charAt(i+1) == '#') {
                sb.append(Character.toLowerCase(origin.charAt(i)));
                i++;
            } else {
                sb.append(origin.charAt(i));
            }
        }
        
        return sb.toString();
    }
}