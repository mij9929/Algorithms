// 장르 별로 가장 많이 재생된 노래를 두개씩 모아 배스트 앨범
// 노래 수록 기준
// 1. 속한 노래가 많이 재생된 장르를 먼저 수록
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록
// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록

import java.util.*;

class Music {
    public int index;
    public int count;
    
    public Music(int index, int count) {
        this.index = index;
        this.count = count;
    }
}

// 장르별 총 재생 횟수,
class Genre {
    public String genre;
    public int totalCount;
    public ArrayList<Music> musics;
    
    public Genre(String genre){
        this.genre = genre;
        this.totalCount = 0;
        this.musics = new ArrayList<>();
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Genre> hashMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            Music music = new Music(i, plays[i]);
            
            String g = genres[i];
            if(!hashMap.containsKey(g))
                hashMap.put(g, new Genre(g));
            
            Genre genre = hashMap.get(g);
            genre.totalCount += plays[i];
            genre.musics.add(music);
        }
        
         ArrayList<Genre> list = new ArrayList<>();
        for(String key : hashMap.keySet()) {
           list.add(hashMap.get(key));
        }
        
        list.sort((a,b) -> Integer.compare(b.totalCount, a.totalCount)); // 장르별 정렬
        
        // 장르 내에서 재생 횟수 정렬
        for(Genre g : list) {
            g.musics.sort((a,b) -> {
                if(a.count == b.count) return Integer.compare(a.index, b.index);
                else return Integer.compare(b.count, a.count);
            });
            if(g.musics.size() == 1) {
                answer.add(g.musics.get(0).index);
            } else {
                answer.add(g.musics.get(0).index);
                answer.add(g.musics.get(1).index);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}