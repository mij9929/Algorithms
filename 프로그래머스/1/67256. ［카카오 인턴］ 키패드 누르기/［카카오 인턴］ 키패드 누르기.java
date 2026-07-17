import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        final String HAND = hand.equals("right") ? "R" : "L";
        Map<Integer,int[]> pad = new HashMap<>();
        int n = 1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                pad.put(n++, new int[]{i,j});
            }
        }
        pad.put(0, new int[]{3,1});
        
        int[] lPos = new int[]{3,0};
        int[] rPos = new int[]{3,2};
        
        StringBuilder resultBuilder = new StringBuilder();
        for(int num : numbers) {
            int[] pos = pad.get(num);

            if(num == 1 || num == 4 || num == 7) {
                lPos = pos;
                resultBuilder.append("L");
            }
            else if(num == 3 || num == 6 || num == 9) {
                rPos = pos;
                resultBuilder.append("R");
            }
            else {
                
                int rdist = Math.abs(pos[0] - rPos[0]) + Math.abs(pos[1] - rPos[1]);
                int ldist = Math.abs(pos[0] - lPos[0]) + Math.abs(pos[1] - lPos[1]);
               
                if(rdist > ldist) {
                    resultBuilder.append("L");
                    lPos = pos;
                }
                else if(rdist < ldist) {
                    resultBuilder.append("R");
                    rPos = pos;
                }
                else {
                    resultBuilder.append(HAND);
                    if(HAND.equals("L")) lPos = pos;
                    else rPos = pos;
                }
            }
        }
        String answer = resultBuilder.toString();
        return answer;
    }
}