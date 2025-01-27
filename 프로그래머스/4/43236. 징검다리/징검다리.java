import java.util.*;

class Solution {
    public boolean check(int mid, int[] points, int n){
        int removed = 0;
        int prev = 0; // 최초는 시작 지점(0);
        
        for(int point : points){
            if(point - prev < mid){
                removed++;
                continue;
            }
            prev = point;
        }
        
        return removed <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int[] points = new int[rocks.length + 1]; // distance 추가한 배열 생성
        for(int i=0; i<rocks.length; i++){
            points[i] = rocks[i];
        }
        points[points.length - 1] = distance;
        
        int start = 0;
        int end = 1000000000;
        
        while(end - start > 1){
            int mid = (start + end) / 2;
            
            if(check(mid, points, n)){
                start = mid;
            } else{
                end = mid;
            }
        }
        
        return answer = start;
    }
}