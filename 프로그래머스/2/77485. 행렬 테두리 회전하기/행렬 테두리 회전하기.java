import java.util.*;


class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        int[][] square = createSquare(rows, columns);
        for(int[] query : queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            
            
            int prev = square[x1][y1];
            int min = prev;
            
            for(int i=y1+1; i<=y2; i++){
                int tmp = square[x1][i];
                square[x1][i] = prev;
                prev = tmp;
                min = Math.min(min, square[x1][i]);
            }
            
            for(int i=x1+1; i<=x2; i++){
                int tmp = square[i][y2];
                square[i][y2] = prev;
                prev = tmp;
                min = Math.min(min, square[i][y2]);
            }
            
            for(int i=y2-1; i>=y1; i--){
                int tmp = square[x2][i];
                square[x2][i] = prev;
                prev = tmp;
                min = Math.min(min, square[x2][i]);
            }
            
            for(int i=x2-1; i>=x1; i--){
                int tmp = square[i][y1];
                square[i][y1] = prev;
                prev = tmp;
                min = Math.min(min, square[i][y1]);
            }
            
            answer[index++] = min;
            
        }
        
        return answer;
    }
    
    public int[][] createSquare(int row, int col){
        int[][] square = new int[row][col];
        int num = 1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
                square[i][j] = num++;
        }
        
        return square;
    }
    
}