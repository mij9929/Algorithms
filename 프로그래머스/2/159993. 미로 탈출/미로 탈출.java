import java.util.*;

class Node {
    int x, y, d;
    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    String[] maps;
    boolean[][] visited;
    int n,m;
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    int[] leverPoint;
    int[] exitPoint;
    int[] startPoint;
    
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        this.maps = maps;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'L') {
                    leverPoint = new int[] {i, j};
                }
                
                if(maps[i].charAt(j) == 'E') {
                    exitPoint = new int[] {i, j};
                }
                
                if(maps[i].charAt(j) == 'S') {
                    startPoint = new int[] {i, j};
                }
            }
        }
        
        int lever = bfs(startPoint[0], startPoint[1], leverPoint[0], leverPoint[1]);
        
        visited = new boolean[n][m];
        int exit = bfs(leverPoint[0], leverPoint[1], exitPoint[0], exitPoint[1]);
        
        if(lever != -1 && exit != -1) return exit + lever;

        return -1;
    }
    
    public int bfs(int x, int y, int tx, int ty) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(now.x == tx && now.y == ty) return now.d;
            
            for(int k=0; k<4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                int nd = now.d + 1;
                
                if(nx>=0 && ny>=0 && nx < n && ny < m) {
                    if(!visited[nx][ny] && maps[nx].charAt(ny)!= 'X') {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, nd));
                    }
                }
            }
        }
        
        return -1;
    }
    

}