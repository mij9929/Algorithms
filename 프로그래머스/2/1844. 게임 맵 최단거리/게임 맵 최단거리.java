import java.util.*;

class Node {
    int x;
    int y;
    int d;
    
    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    public boolean[][] visited;
    public int[][] maps;
    public int n, m;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        int answer = bfs(0, 0);
        return answer;
    }
    
    public int bfs(int i, int j) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j, 1));
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(now.x == n-1 && now.y == m-1) return now.d;
            
            for(int k=0; k<4; k++) {
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                int d = now.d + 1;
                
                
                if(x>=0 && y>=0 && x<n && y<m && maps[x][y] != 0) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new Node(x,y,d));
                    }
                }
            }
        }
        
        return -1;
    }
}