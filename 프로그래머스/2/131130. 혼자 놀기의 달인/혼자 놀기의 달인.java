import java.util.*;

class Solution {
    boolean[] boolBox;
    int trueCount;

    public int play(int[] cards, int idx, int depth){
        if(boolBox[idx]) return depth;
        else {
            boolBox[idx] = true;
            return play(cards, cards[idx]-1, depth+1);
        }
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        boolBox = new boolean[cards.length];
        int[] resultArrays = new int[cards.length];
        for(int i=0; i<cards.length; i++){
            if(!boolBox[i]) resultArrays[i] = play(cards, i, 0);
            
        }
        
        Arrays.sort(resultArrays);
        answer = resultArrays[cards.length-1]*resultArrays[cards.length-2];
        return answer;
    }
}