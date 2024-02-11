import java.util.*;
import java.lang.Math;

class Solution {
    
    static class Player{
        public int count;
        public boolean isWin;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        
        // 정상적으로 나올 수 없는 경우의 수 :
        // 1. O와 X의 갯수: O가 하나 더 많거나 같아야함 -> O count >= X count
        // 2. O와 X의 중 하나라도, 3을 만들었음.
        Player player1 = new Player();
        Player player2 = new Player();
        int map[][] = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'O') {
                    map[i][j] = 1;
                    player1.count ++;
                }
                else if(board[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                    player2.count ++;
                }
            }
        }
    
        for(int i=0; i<3; i++){
            if(Math.abs(map[0][i] + map[1][i] + map[2][i]) == 3){
                if((map[0][i] + map[1][i] + map[2][i]) == 3) player1.isWin = true;
                if((map[0][i] + map[1][i] + map[2][i]) == -3) player2.isWin = true;
            }
            
            if(Math.abs(map[i][0] + map[i][1] + map[i][2]) == 3){
                if((map[i][0] + map[i][1] + map[i][2]) == 3) player1.isWin = true;
                if((map[i][0] + map[i][1] + map[i][2]) == -3) player2.isWin = true;
            }
        }
        
        if(map[0][0] + map[1][1] + map[2][2] == 3) player1.isWin = true;
        else if(map[0][0] + map[1][1] + map[2][2] == -3) player2.isWin = true;
        
        if(map[0][2] + map[1][1] + map[2][0] == 3) player1.isWin = true;
        else if(map[0][2] + map[1][1] + map[2][0] == -3) player2.isWin = true;
        
        
        if(!(player1.count == player2.count || player1.count == player2.count+1)) return 0;
        if(player2.isWin || player1.isWin) {
            if(player1.isWin && player2.isWin) return 0;
            if(player1.isWin && player1.count == player2.count) return 0; // 1이 이기면 O가 하나 더 많아야함.
            if(player2.isWin && player1.count == player2.count + 1) return 0; //2가 이기면 말의 개수가 같아야함.
        }
        
        
        return 1;
    }
}