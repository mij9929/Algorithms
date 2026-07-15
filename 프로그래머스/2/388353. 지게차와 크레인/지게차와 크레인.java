import java.util.*;

class Solution {
    public int n,m;
    public String[] storage;
    public char[][] map;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        this.storage = storage;
        n = storage.length + 2;
        m = storage[0].length() + 2;
        map = new char[n][m];
        
        for(char[] row : map) {
            Arrays.fill(row, '.');
        }
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<storage[0].length(); j++) {
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(String req : requests) {
            int op = req.length();
            char ch = req.charAt(0);
            if(op == 1) func1(ch);
            else func2(ch);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != '.') answer++;
            }
        }
        
        return answer;
    }
    
    // 지게차 옵션
    public void func1(char c) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> removeList = new ArrayList<>();
        
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            
            for(int dir =0; dir<4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny] == '.') {
                    queue.offer(new int[] {nx, ny});
                }
                
                else if(map[nx][ny] == c) {
                    removeList.add(new int[] {nx, ny});
                }
                
                visited[nx][ny] = true;
            }
        }
        
        for(int[] pos : removeList) {
            map[pos[0]][pos[1]] = '.';
        }
    }
    
    // 크레인
    public void func2(char c) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(c == map[i][j]) {
                    map[i][j] = '.';
                }
            }
        }
    }
}