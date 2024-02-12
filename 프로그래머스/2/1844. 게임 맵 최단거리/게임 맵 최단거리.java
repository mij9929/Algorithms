import java.util.*;

class Solution {
    static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
    static boolean[][] visited;
    static class Node{
        public int x;
        public int y;
        public int d;
        
        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int dfs(int i, int j, int n, int m, int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i,j,1));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if (now.x == n-1 && now.y == m-1) {
				return now.d;
			}
            
            for(int k=0; k<4; k++){
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                int d = now.d + 1;
                if(x>=0 && y>=0 && x<n && y<m){
                    if(!visited[x][y] && maps[x][y] != 0){
                        visited[x][y] = true;
                        queue.add(new Node(x,y,d));
                    }
                }   
            }
        }
        
        return -1;
        
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int x = maps.length;
        int y = maps[0].length;
        visited = new boolean[x][y];
        return answer = dfs(0,0,x,y, maps);
    }
}