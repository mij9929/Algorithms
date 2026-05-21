import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        int size = board.length;
        int[] boardIdx = new int[size];
        for(int i=0; i<size; i++) {
            boardIdx[i] = -1;
        }
        
        for(int i=0; i<board[0].length; i++) {
            for(int j=0; j<size; j++) {
                if(board[j][i] != 0) {
                    boardIdx[i] = j;
                    break;
                }
            }
        }

        System.out.println("배열 값");
        System.out.println(Arrays.toString(boardIdx));
        
        for(int i=0; i<moves.length; i++) {
            int idx = boardIdx[moves[i]-1];
            if(idx >= board.length) continue;
            if(!bucket.isEmpty() && bucket.peek() == board[idx][moves[i]-1]){
                bucket.pop();
                answer+=2;   
            }
            
            else
                bucket.push(board[idx][moves[i]-1]);
            
            boardIdx[moves[i]-1]++;
        }
        


        return answer;
    }
}