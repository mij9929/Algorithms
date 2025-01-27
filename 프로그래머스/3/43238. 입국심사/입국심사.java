class Solution {
    public boolean check(long mid, long n, int[] times){
        long c = 0;
        for(int time : times){
            c += mid / time;
        }
        return c >= n; // mid시간동안 심사하는데 걸리는 인원
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = 100000000000000000L;
        
        while(end > start){
            long mid = (start + end) / 2;
            
            if(check(mid, n, times)){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        
        return answer = start;
    }
}