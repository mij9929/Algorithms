class Solution {
    public long solvedTime(int[] diffs, int[] times, long level){
        long time = times[0]; // 소요 시간
        for(int i=1; i<diffs.length; i++){
            if(level >= diffs[i]){ // 문제를 풀 숙련도가 된다면
                time += times[i];
            }
            else{ // 숙련도 부족하면
                time += (long)(diffs[i] - level) * (times[i] + times[i-1]);
                time += times[i];
            }
            
        }
        
        return time;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        long start = 1;
        long end = limit;
        long mid = 0;
        while(start < end){
            mid = (start + end) / 2;
            if(solvedTime(diffs, times, mid) <= limit) end = mid;
            else start = mid+1;
        }
        answer = (int) start;

        return answer;
    }
}