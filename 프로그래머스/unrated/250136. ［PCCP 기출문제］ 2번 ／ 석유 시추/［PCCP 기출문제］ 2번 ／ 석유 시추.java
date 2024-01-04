import java.util.*;
import java.lang.Math;

class Solution {
    static int n,m;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
    static int[] ansList;
    
    static class Node{
        int x,y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int i, int j, int[][] land) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(i,j);
        queue.offer(node);
        int cnt = 1;
        visited[i][j] = true;
        boolean[] check = new boolean[land[0].length]; // 각 열에서 꽂았을 때 얻을 수 있는지 체크
        check[j] = true;
        
        while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now.x + dx[k];
				int y = now.y + dy[k];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (visited[x][y] == false && land[x][y] == 1) {
                        if(!check[y])
                            check[y] = true;
                        
						visited[x][y] = true;
						queue.add(new Node(x, y));
                        cnt++;
					}
				}
			}
		}
        
        for(int idx=0; idx<land[0].length; idx++){
            if(check[idx])
                ansList[idx] += cnt;
        }
            
        
	}
    
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        ansList = new int[m];
        visited = new boolean[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[j][i] && land[j][i] == 1){
                    bfs(j,i,land);
                }
            }
        }
        
        for(int i=0; i<m; i++)
            answer = Math.max(answer, ansList[i]);
        return answer;
    }
}