class Solution {
     public int solved(int start, int end, int size){
        int between = end - start + 1;
        if(between <= 0) return 0;
        else {
            if(between%size == 0){
                return between / size;
            }
            else
                return between/size + 1;
        }
    }
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;
        for(int i=0; i<len-1; i++){
                answer += solved(stations[i] + w + 1, stations[i+1] - w - 1, 2*w+1);
            }
        answer += solved(1, stations[0] - w - 1, 2*w+1) + solved(stations[len-1] + w + 1, n, 2*w+1);
        
        return answer;
    }
    
   
    
}