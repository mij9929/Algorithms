import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int result = 0;
        
        int moveLen = moves.length;
        int boardLen = board.length;
        
        ArrayList<Integer> baguni = new ArrayList<Integer>();
        
        for(int moveIndex=0; moveIndex<moveLen; moveIndex++){
            for(int index=0; index < boardLen; index++){
                int moveValue = moves[moveIndex]-1;
                if(board[index][moveValue] > 0){
                    baguni.add(board[index][moveValue]);
                    board[index][moveValue] = 0;
                    break;
                }
            }
            
            if(baguni.size() >= 2){
                if(baguni.get(baguni.size()-1) == baguni.get(baguni.size()-2)){
                    baguni.remove(baguni.size()-1);
                    baguni.remove(baguni.size()-1);
                    result += 2;
                }
            }
        }
        
        answer = result;
        
        
        return answer;
    }
}