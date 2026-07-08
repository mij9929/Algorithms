import java.util.*;

class Robot {
    int lx, ly;
    int rx, ry;
    int d;
    
    public Robot(int lx, int ly, int rx, int ry, int d) {
        this.lx = lx;
        this.ly = ly;
        this.rx = rx;
        this.ry = ry;
        this.d = d;
    }
}

class Solution {
    int[][] board;
    int n;
    int answer;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    boolean[][][][] visited;
    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        visited = new boolean[n][n][n][n];
        answer = Integer.MAX_VALUE;
        bfs();
        return answer;
    }
    
    public void bfs() {
        Queue<Robot> queue = new ArrayDeque<>();
        queue.offer(new Robot(0,0,0,1,0));
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;
        
        while(!queue.isEmpty()) {
            Robot now = queue.poll();
            
            if(isGoal(now)) {
                answer = Math.min(answer, now.d);
                return;
            }
            
            List<Robot> nextMoveList = getNextPositions(now);
            
            for(Robot next : nextMoveList) {
                int nlx = next.lx;
                int nly = next.ly;
                int nrx = next.rx;
                int nry = next.ry;
                
                
                if(visited[nlx][nly][nrx][nry] || 
                   visited[nrx][nry][nlx][nly]) continue;
                
                queue.offer(next);
                
                visited[nlx][nly][nrx][nry] = true;
                visited[nrx][nry][nlx][nly] = true;
                
            }
        }
        
    }
    
    public boolean isGoal(Robot robot) {
        if(robot.lx == n-1 && robot.ly == n-1) return true;
        if(robot.rx == n-1 && robot.ry == n-1) return true;
        return false;
    }
    
    public List<Robot> getNextPositions(Robot robot) {
        List<Robot> result = new ArrayList<>();
        
        int lx = robot.lx;
        int ly = robot.ly;
        int rx = robot.rx; 
        int ry = robot.ry;
        int nd = robot.d+1;
        
        // 상하좌우 평행 이동
        for(int dir=0; dir<4; dir++) {
            int nlx = lx + dx[dir];
            int nly = ly + dy[dir];
            int nrx = rx + dx[dir];
            int nry = ry + dy[dir];
            
            if(isEmpty(nlx, nly) && isEmpty(nrx,nry)) {
                result.add(new Robot(nlx, nly, nrx, nry, nd));
            }
        }
        
        // 가로 상태 위/아래 회전
        if(lx == rx) {
            for(int dir : new int[]{-1, 1}) {
                int nlx = lx + dir;
                int nrx = rx + dir;
                
                if(isEmpty(nlx, ly) && isEmpty(nrx, ry)) {
                    result.add(new Robot(lx, ly, nlx, ly, nd));
                    result.add(new Robot(rx, ry, nrx, ry, nd));
                }
            }
        }
        
        if(ly == ry) {
            for(int dir : new int[]{-1, 1}) {
                int nly = ly + dir;
                int nry = ry + dir;
                
                if(isEmpty(lx, nly) && isEmpty(rx, nry)) {
                    result.add(new Robot(lx, ly, lx, nly, nd));
                    result.add(new Robot(rx, ry, rx, nry, nd));
                }
            }
        }
        
        return result;
    }
    
    public boolean isEmpty(int x, int y) {
        if(x < 0 || x >=n || y <0 || y >=n) return false;
        
        return board[x][y] == 0;
    }
}