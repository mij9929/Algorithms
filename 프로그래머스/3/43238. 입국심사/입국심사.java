class Solution {
    public boolean isValid(long t, long n, int[] times){
        long c = 0;
        for(int time : times){
            c += t / time;
        }
        return c >= n;
    }
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = 100000000000000000L;
        
        while(end > start){
            long mid = (start + end) / 2;
            
            if(isValid(mid, n, times)){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        
        return answer = start;
    }
}