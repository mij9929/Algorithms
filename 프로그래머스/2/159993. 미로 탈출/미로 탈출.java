import java.util.*;
class Solution {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][][] visited;
    
    class Node{
        int x;
        int y;
        int z;
        int lever;
        
        public Node(int x, int y, int z, int lever){
            this.x = x;
            this.y = y;
            this.z = z;
            this.lever = lever;
        }
    }
    
    public int bfs(int startX, int startY, int n, int m, String[] maps){
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
    
            if(maps[now.x].charAt(now.y) == 'E' && now.lever == 1){
                answer = (answer == -1 ? now.z : (answer > now.z ? now.z : answer)); 
            }
            
            for(int k=0; k<4; k++){
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                int z = now.z;
                int lever = now.lever;
                
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(!visited[x][y][lever] && maps[x].charAt(y) != 'X'){
                        visited[x][y][lever] = true;
                        if(maps[x].charAt(y) == 'L'){
                            lever = 1;
                            visited[x][y][lever] = true;
                        }
                        queue.offer(new Node(x,y,z+1,lever));
                    }
                }      
            }
        }
        
        return answer;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        visited = new boolean[n][m][2];
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        visited[startX][startY][0] = true;
        answer = bfs(startX, startY, n, m, maps);
        
        return answer;
    }
}