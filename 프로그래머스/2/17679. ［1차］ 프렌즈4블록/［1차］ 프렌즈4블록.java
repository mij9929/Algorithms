import java.util.*;

class Solution {
    public int n,m;
    char[][] map;
    Set<int[]> removeList;
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        removeList = new HashSet<>();
        
        map = new char[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                char ch = board[i].charAt(j);
                map[i][j] = ch;
            }
        }
        
        boolean flag = true;
        
        while(flag) {
            flag = false;
            
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(squareFlag(i,j)) flag = true;;
                }
            }
            
            Iterator<int[]> iterator = removeList.iterator();
            
            while(iterator.hasNext()) {
                int[] pos = iterator.next();
                map[pos[0]][pos[1]] = '.';
                iterator.remove();
            }
            
            for(int i=0; i<n; i++) {
                Queue<Character> q1 = new ArrayDeque<>();
                Queue<Character> q2 = new ArrayDeque<>();
                for(int j=0; j<m; j++) {
                    if(map[j][i] == '.') q1.offer(map[j][i]);
                    else q2.offer(map[j][i]);
                }
                int idx = 0;
                while(!q1.isEmpty()) {
                    map[idx++][i] = q1.poll();
                }
                while(!q2.isEmpty()) {
                    map[idx++][i] = q2.poll();
                }
            }
        }
        int answer = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == '.') answer++;
            }
        }
        
        
        return answer;
    }
    
    public boolean squareFlag(int x, int y) {
        if(map[x][y] == '.') return false;
        if(map[x][y] == map[x+1][y] && map[x+1][y] == map[x+1][y+1] && map[x+1][y+1] == map[x][y+1]) {
            removeList.add(new int[]{x,y});
            removeList.add(new int[]{x+1, y+1});
            removeList.add(new int[]{x+1, y});
            removeList.add(new int[]{x, y+1});
            
            return true;
        }
        
        return false;
    }
    
    
}