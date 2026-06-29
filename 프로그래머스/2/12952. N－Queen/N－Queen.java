import java.util.*;

class Solution {
    public int[][] map;
    public int cnt;
    
    public int solution(int n) {
        map = new int[n][n];
        cnt = 0;
        dfs(0, n);
        return cnt;
    }
    
    public void dfs(int depth, int n) {
        if(depth == n){
            cnt++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(map[depth][i] == 0) {
                mark(1, depth, i, n);
                dfs(depth+1, n);
                mark(-1, depth, i, n);
            }
        }
    }
    
    public void mark(int flag, int row, int col, int n) {
        // 가로, 세로
        for(int i=0; i<n; i++) {
            map[row][i] += flag;
            map[i][col] += flag;
        }
        
        // 대각선
        for(int i = 0; i < n; i++) {
            if(row + i >= n || col + i >= n) break;
            map[row + i][col+i] += flag;
        }
        
        for(int i = 0; i < n; i++) {
            if(row - i < 0 || col - i < 0) break;
            map[row-i][col-i] += flag;
        }
        
        for(int i = 0; i < n; i++) {
            if(row - i < 0 || col + i >= n) break;
            map[row - i][col+i] += flag;
        }
        
        for(int i = 0; i < n; i++) {
            if(row + i >= n || col - i < 0) break;
            map[row + i][col - i] += flag;
        }

    }
}