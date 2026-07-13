class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int serverCount = 0;
        int[] serverExpire = new int[24 + k + 1];
        
        for(int time = 0; time < 24; time++) {
            serverCount -= serverExpire[time];
            int required = players[time]/m;
            
            if(serverCount < required) {
                int addedServer = required - serverCount;
                
                serverCount += addedServer;
                serverExpire[time + k] += addedServer;
                answer += addedServer;
                
            }
        }
        return answer;
    }
}