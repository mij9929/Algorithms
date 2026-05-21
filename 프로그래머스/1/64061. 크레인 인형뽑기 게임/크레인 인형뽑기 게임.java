import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        int size = board.length;
        int[] boardIdx = IntStream.range(0, size)
                                  .map(i -> IntStream.range(0, board.length)
                                                     .filter(j -> board[j][i] != 0)
                                                     .findFirst()
                                                     .orElse(board.length))
                                  .toArray();
        
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