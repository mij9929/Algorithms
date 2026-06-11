import java.util.*;

class Solution {
    public boolean[] visited;
    public int[][] computers;
    
    public void dfs(int now) {
        visited[now] = true;
        
        for(int i=0; i<computers[now].length; i++) {
            if(!visited[i] && computers[now][i] == 1){
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}