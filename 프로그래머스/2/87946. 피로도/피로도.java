import java.util.*;
import java.lang.*;

class Solution {
    public int count;
    public int len;
    public int[][] dungeons;
    public boolean[] visited;
    public int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        this.dungeons = dungeons;
        len = dungeons.length;
        visited = new boolean[len];
        count = 0;
        dfs(k, 0);
        return answer;
    }
    
    public void dfs(int health, int depth) {
        answer = Math.max(answer, depth);
        if(depth == len) return;
        
        for(int i=0; i<len; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= health) {
                    visited[i] = true;
                    dfs(health - dungeons[i][1], depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}