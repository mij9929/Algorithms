import java.util.*;

class Solution {
    public boolean[] visited;
    public int[][] q;
    public int[] ans;
    public int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        visited = new boolean[n+1];
        this.q = q;
        this.ans = ans;
        
        dfs(n, 1, 0);
        return answer;
    }
    
    public void dfs(int n, int start, int depth) {
        if(depth == 5) {
            for(int i=0; i<q.length; i++) {
                if(!check(q[i], ans[i])) return;
            }
            answer++;
            return;
        }
        
        for(int i=start; i<=n; i++) {
            visited[i] = true;
            dfs(n, i+1, depth+1);
            visited[i] = false;
        }
    }
    
    public boolean check(int[] question, int ans) {
        int cnt = 0;
        for(int ques : question) {
            if(visited[ques]) cnt++;
        }
        return cnt == ans;
    }
}