import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[][] patterns = {
            pattern1,
            pattern2,
            pattern3
        };
        
        int[] scores = new int[3];
        
    
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<patterns.length; j++) {
                if(answers[i] == patterns[j][i%(patterns[j].length)]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores)
            .max()
            .getAsInt();
    
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(maxScore == scores[i]) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().sorted().mapToInt(a -> a.intValue()).toArray();
    }
}