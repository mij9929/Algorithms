import java.util.*;
import java.lang.*;

class Solution {
    int n;
    boolean[] visited;
    int answer;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        this.dungeons = dungeons;
        n = dungeons.length;
        
        visited = new boolean[n];
        dfs(k, 0);
        return answer;
    }
    
    public void dfs(int health, int depth) {
        answer = Math.max(answer, depth);
        
        if(depth == n) {
            return;
        } 
        
        for(int i=0; i<n; i++) {
            if(health < dungeons[i][0]) continue;
            if(!visited[i]){
                visited[i] = true;
                dfs(health - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}