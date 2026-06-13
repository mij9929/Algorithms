import java.util.*;


class Node {
    int x, y;
    int cost;
    int direction;
    
    public Node(int x, int y, int cost, int direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }
}

class Solution {
    public int[][][] cost;
    public int[][] board;
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    public int len;
    public int answer;
    
    public int getDirection(int k) {
        if(k < 2) return 0; // y좌표가 움직이면 0
        else return 1; // x좌표가 움직이면 1 리턴
    }
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        this.board = board;
        len = board.length;
        cost = new int[len][len][2];
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs();
        return answer;
    }
    
    public void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0,0,0,-1)); // 초기 direction은 -1,
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(now.x == len-1 && now.y == len-1) {
                answer = Math.min(answer, now.cost);
            }
            
            for(int k=0; k<4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                int direction = getDirection(k);
                
                if(nx >= 0 && ny >=0 && nx < len && ny < len) {
                    if(board[nx][ny] != 1) {
                        int nextCost = now.cost;
                        if(now.direction == -1) nextCost += 100;
                        else if(now.direction == direction) nextCost+=100;
                        else nextCost += 600;
                        
                        if (nextCost < cost[nx][ny][direction]) {
                            cost[nx][ny][direction] = nextCost;
                            queue.offer(new Node(nx, ny, nextCost, direction));
                        }
                    }
                }
            }
        }
    }

}