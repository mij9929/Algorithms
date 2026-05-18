import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // 어떤 방향으로 왔는지도 체크
        // ex) map[4][4][0] = true이면, 위쪽방향(4,3)에서 (4,4)로 옴
        boolean[][][] map = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        
        
        
        int len = dirs.length();
        for(int i=0; i<len; i++) {
            int[] move = move(dirs.charAt(i));
            int direction = setDirection(dirs.charAt(i));
            
            int ny = y + move[0];
            int nx = x + move[1];
            
            if(ny < 0 || ny > 10 || nx < 0 || nx > 10) continue;
            
            if(!map[ny][nx][direction]) {
                map[ny][nx][direction] = true;
                // 반대방향도 체크
                map[y][x][(direction+2)%4] = true;
                answer++;
            }
            
            y = ny;
            x = nx;
        }
        
        return answer;
    }
    
    public int[] move(char dir) {
        if (dir == 'U') return new int[]{1, 0};
        else if (dir == 'R') return new int[]{0, 1};
        else if (dir == 'D') return new int[]{-1, 0};
        else return new int[]{0, -1};
    }
    
    public int setDirection(char dir) {
        if (dir == 'U') return 0;
        else if (dir == 'R') return 1;
        else if (dir == 'D') return 2;
        else return 3;
    }
}