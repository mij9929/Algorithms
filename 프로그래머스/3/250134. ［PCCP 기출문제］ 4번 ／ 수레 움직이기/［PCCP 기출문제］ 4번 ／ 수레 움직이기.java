import java.util.*;

class Node {
    int x, y, v;
    public Node(int x, int y, int v) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int[][] maze;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int n,m;
    
    public int bfs(int rx, int ry, int bx, int by) {
        Queue<Node> rq = new ArrayDeque<>();
        Queue<Node> bq = new ArrayDeque<>();
        rq.offer(new Node(rx, ry, 0));
        rq.offer(new Node(bx, by, 0));
        
        while(!rq.isEmpty() && !bq.isEmpty()) {
            Node rNow = rq.poll();
            Node bNow = bq.poll();
            
            if()
        }
    }

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        visited = new boolean[n][m][2];
        int[] rs = new int[2];
        int[] bs = new int[2];
        
       for(int i=0; i<n; i++) {
           for(int j=0; j<m; j++) {
               if(maze[i][j] == 1) {
                   rs = new int[]{i, j};
               } else if(maze[i][j] == 2) {
                   bs = new int[]{i, j};
               }
           }
       }
        
        bfs(rs[0], rs[1], bs[0], bs[1]);
        
        int answer = 0;
        return answer;
    }
}