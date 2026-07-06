import java.util.*;

class Solution {
    int n,m;
    int[][] maze;
    
    boolean[][] redVisited;
    boolean[][] blueVisited;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    int answer;
    
    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        answer = Integer.MAX_VALUE;
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        
        int redStartX = -1, redStartY = -1;
        int blueStartX = -1 , blueStartY = -1;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maze[i][j] == 1) {
                    redStartX = i;
                    redStartY = j;
                }
                
                if(maze[i][j] == 2) {
                    blueStartX = i;
                    blueStartY = j;
                }
            }
        }
        
        redVisited[redStartX][redStartY] = true;
        blueVisited[blueStartX][blueStartY] = true;
        
        
        dfs(redStartX, redStartY, blueStartX, blueStartY, 0);
        
        if(answer == Integer.MAX_VALUE) return 0;
        
        return answer;
    }
    
    public void dfs(int redX, int redY, int blueX, int blueY, int depth) {
        if(answer <= depth) return;
        
        if(isRedGoal(redX, redY) && isBlueGoal(blueX, blueY)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        List<int[]> redNextList = getNextPositions(redX, redY, true);
        List<int[]> blueNextList = getNextPositions(blueX, blueY, false);
        
        for(int[] redNext : redNextList) {
            int redNextX = redNext[0];
            int redNextY = redNext[1];
            for(int[] blueNext : blueNextList) {
                int blueNextX = blueNext[0];
                int blueNextY = blueNext[1];
                
                if(redNextX == blueNextX && redNextY == blueNextY) continue;
                
                if(redNextX == blueX && redNextY == blueY && blueNextX == redX && blueNextY == redY) continue;
                
                boolean redMoved = !isRedGoal(redX, redY);
                boolean blueMoved = !isBlueGoal(blueX, blueY);
                
                if(redMoved) redVisited[redNextX][redNextY] = true;
                if(blueMoved) blueVisited[blueNextX][blueNextY] = true;
                
                dfs(redNextX, redNextY, blueNextX, blueNextY, depth + 1);
                
                if(redMoved) redVisited[redNextX][redNextY] = false;
                if(blueMoved) blueVisited[blueNextX][blueNextY] = false;
                
            }
        }
    }
    
    public boolean isRedGoal(int redX, int redY) {
        return maze[redX][redY] == 3;
    }
    
    public boolean isBlueGoal(int blueX, int blueY) {
        return maze[blueX][blueY] == 4;
    }
    
    public List<int[]> getNextPositions(int x, int y, boolean isRed) {
        List<int[]> result = new ArrayList<>();
        
        if(isRed && isRedGoal(x, y)) {
            result.add(new int[] {x,y});
            return result;
        }
        
        if(!isRed && isBlueGoal(x, y)) {
            result.add(new int[] {x,y});
            return result;
        }
        
        boolean[][] visited = isRed ? redVisited : blueVisited;
        
        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX >=0 && nextX < n && nextY >=0 && nextY < m) {
                if(!visited[nextX][nextY] && maze[nextX][nextY] != 5) {
                    result.add(new int[] {nextX, nextY});
                }
            }
        }
        
        return result;
    }
}