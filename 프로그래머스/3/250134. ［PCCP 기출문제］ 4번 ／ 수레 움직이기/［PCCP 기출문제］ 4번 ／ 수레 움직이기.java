import java.util.*;

class Solution {
    public static int[][] maze;
    public static boolean[][] rVisited;
    public static boolean[][] bVisited;
    
    public static int n,m;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public static int rsx, rsy;
    public static int bsx, bsy;
    public static int answer;
    
    public void dfs(int rx, int ry, int bx, int by, int depth) {
        if(depth >= answer) {
            return;
        }
        
        boolean redExit = (maze[rx][ry] == 3);
        boolean blueExit = (maze[bx][by] == 4);
        
        if(redExit && blueExit) {
            answer = Math.min(answer, depth);
            return;
        }
        
        List<int[]> redNextList = getNextPositions(rx, ry, redExit, rVisited);
        List<int[]> blueNextList = getNextPositions(bx, by, blueExit, bVisited);
        
        for(int[] redNext : redNextList) {
            for(int[] blueNext: blueNextList) {
                int nrx = redNext[0];
                int nry = redNext[1];
                int nbx = blueNext[0];
                int nby = blueNext[1];
                
                // 동시에 같은 칸으로 이동 불가
                if (nrx == nbx && nry == nby) continue;
                
                // 자리 바꾸기 불가
                if (nrx == bx && nry == by && nbx == rx && nby == ry) continue;
                
 
                rVisited[nrx][nry] = true;
                bVisited[nbx][nby] = true;
                
                dfs(nrx, nry, nbx, nby, depth + 1);
                
                rVisited[nrx][nry] = false;
                bVisited[nbx][nby] = false;
                
            }
        }

    }
    
    public List<int[]> getNextPositions(int x, int y, boolean isExit, boolean[][] visited) {
        List<int[]> result = new ArrayList<>();
        
        if(isExit) {
            result.add(new int[] {x, y});
            return result;
        }
        
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(!visited[nx][ny] && maze[nx][ny] != 5) {
                    result.add(new int[]{nx, ny});
                }
            }
        }
        
        return result;
    }
    
    public int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        
        rVisited = new boolean[n][m];
        bVisited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maze[i][j] == 1) {
                    rsx = i; 
                    rsy = j;
                }
                
                else if(maze[i][j] == 2) {
                    bsx = i;
                    bsy = j;
                }
            }
        }
        rVisited[rsx][rsy] = true;
        bVisited[bsx][bsy] = true;
        
        dfs(rsx, rsy, bsx, bsy, 0);
        

        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
}