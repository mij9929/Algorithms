import java.util.*;

class City {
    String name;
    int idx;
    public City(String name, int idx) {
        this.name = name;
        this.idx = idx;
    }
}

class Solution {
    public PriorityQueue<City> pq;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a.idx, b.idx));
        for(int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        
        int currentSize = 0;
        
        for(int i=0; i<cities.length; i++) {
            City city = new City(cities[i], i);
            City find = findCity(cities[i]);
            
            // 캐시 메모리 사이즈보다 작아야하고, 메모리에 해당 도시가 없을 때 (캐시 미스)
            if(currentSize < cacheSize && find == null) {
                pq.offer(city);
                currentSize++;
                answer += 5;
            }
            
            // 메모리에 해당 도시가 있을 때 (캐시 히트)
            else if(find != null) {
                pq.remove(find);
                pq.offer(city);
                answer ++;
            }
            
            // 메모리가 다 차고, 메모리에 해당 도시가 없을 때 (캐시 미스) 
            // 또한 cacheSize가 0이 아니어야함.
            else if(find == null){
                pq.poll();
                pq.offer(city);
                answer += 5;
            }
        }
        
        return answer;
    }
    
    public City findCity(String city) {
        City search = pq.stream()
            .filter(c -> c.name.equals(city))
            .findFirst()
            .orElse(null);
        
        return search;
    }
}