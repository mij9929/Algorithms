import java.util.*;

class Result {
    boolean win;
    int count;
    
    Result(boolean win, int count) {
        this.win = win;
        this.count = count;
    }
}

class Solution {
    public int[][] board;
    public int n,m;
    public boolean[][] visited;
    public int answer;
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        answer = -1;
        this.board = board;
        n = board.length;
        m = board[0].length;
        
        Result result = dfs(aloc[0], aloc[1], bloc[0], bloc[1], true, 0);
        return result.count;
    }
    
    public Result dfs(int rx, int ry, int bx, int by, boolean isRed, int depth) {
        int x = -1, y = -1;
        if(isRed) {
            x = rx;
            y = ry;
        } else {
            x = bx;
            y = by;
        }
        
        if(!canMove(x,y)) {
            return new Result(false, 0);
        }
        
        boolean canWin = false;
        
        int minWinCount = Integer.MAX_VALUE;
        int maxLoseCount = 0;
        
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!isRange(nx, ny)) continue;
            if(board[nx][ny] == 0) continue;
            
            board[x][y] = 0;
            
            Result nextResult;
            
            if(isRed) {
                nextResult = dfs(nx, ny, bx, by, !isRed, depth + 1);
            }
            else {
                nextResult = dfs(rx, ry, nx, ny, !isRed, depth + 1);
            }
            
            board[x][y] = 1;
            
            // 현재 플레이어가 한 번 움직였으므로 + 1
            int currentMoveCount = nextResult.count + 1;
            
            // 다음 턴의 상대가 진다면, 현재 플레이어는 이긴다.
            if(!nextResult.win) {
                canWin = true;
                
                // 이길 수 있다면 최대한 빨리 승리
                minWinCount = Math.min(minWinCount, currentMoveCount);
            } else {
                // 상대가 이긴다면, 현재 플레이어의 패배 경로
                // 질 수 밖에 없다면, 최대한 오래 버틴다.
                maxLoseCount = Math.max(maxLoseCount, currentMoveCount);
            }
        }
        
        if(canWin) {
            return new Result(true, minWinCount);
        }
        
        return new Result(false, maxLoseCount);
    }
    
    public boolean canMove(int x, int y) {
        // 현재 발판이 사라져있으면 return false;
        if(board[x][y] == 0) return false;
        
        // 움직일 수 있는 곳이 없으면 return false;
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!isRange(nx,ny)) continue;
            if(board[nx][ny] == 0) continue;
            
            return true;
        }
        
        return false;
    }

    public boolean isRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        
        return true;
    }
}