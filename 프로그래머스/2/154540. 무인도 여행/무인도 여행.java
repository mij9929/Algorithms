import java.util.*;

class Solution {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public boolean[][] visited;
    
    class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int bfs(int i, int j, int n, int m, String[] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i,j));
        int sum = 0;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            sum += (int)(maps[now.x].charAt(now.y) - '0');
            
            for(int k=0; k<4; k++){
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(!visited[x][y] && maps[x].charAt(y) != 'X'){
                        queue.offer(new Node(x,y));
                        visited[x][y] = true;
                    }    
                }
            }
        }
        
        return sum;
    }
    
    public int[] solution(String[] maps) { //x는 바다, 숫자는 무인도(상하좌우 = 하나의 무인도, 숫자는 식량)
        int n = maps.length;
        int m = maps[0].length();
        int[][] newMaps = new int[n][m];
        visited = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(bfs(i,j,n,m,maps));
                }
            }
        }
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        if(size == 0) return new int[] {-1};
        return answer;
    }
}
