import java.util.*;

class Point{
    public long x,y;
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}

class Solution {    
    public String[] solution(int[][] line) {
        String[] answer = {};
        int len = line.length;
        List<Point> points = new ArrayList<Point>();
        long a,b,c,d,e,f = 0;
        long minX = Long.MAX_VALUE, minY=Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY=Long.MIN_VALUE;
        
        
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                //1. ax + by + e = 0;
                //2. cx + dy + f = 0;
                // ad - bc = 0 -> 평행 혹은 직선
                // x = bf-ed/ad-bc, y = ec-af/ad-bc;
                a = line[i][0];
                b = line[i][1];
                e = line[i][2];
                c = line[j][0];
                d = line[j][1];
                f = line[j][2];
                
                if(a*d == b*c) continue;
                
                double tx = (double)(b*f - e*d)/(a*d-b*c);
                double ty = (double)(e*c - a*f)/(a*d-b*c);
                
                if(tx%1 == 0 && ty%1 == 0){
                    points.add(new Point((long)tx,(long)ty));
                }
                
                for(Point point : points){
                    if(point.x > maxX) maxX = point.x;
                    if(point.y > maxY) maxY = point.y;
                    if(point.x < minX) minX = point.x;
                    if(point.y < minY) minY = point.y;
                    
                }
            }
        }
                
                char[][] map = new char[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
                
                for(char[] row : map){
                    Arrays.fill(row, '.');
                }
                
                for(Point point: points){
                    int x = (int)(point.x - minX);
                    int y = (int)(maxY - point.y);
                    
                    map[y][x] = '*';
                }
                
                int ansLen = map.length;
                answer = new String[ansLen];
                
                for(int k=0; k<ansLen; k++){
                    answer[k] = new String(map[k]);
                }
                     
        

        
        return answer;
    }
    
}