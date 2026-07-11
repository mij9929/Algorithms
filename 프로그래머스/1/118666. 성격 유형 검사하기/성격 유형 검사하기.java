import java.util.*;

class Solution {
    char[][] types = {{'R', 'T'}, {'C','F'}, {'J','M'}, {'A','N'}};
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = choices.length;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<2; j++) {
                map.put(types[i][j], 0);
            }
        }
        
        for(int i=0; i<len; i++) {
            int score = Math.abs(4 - choices[i]);
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            
            if(choices[i] < 4) map.put(c1, map.getOrDefault(c1, 0) + score);
            else map.put(c2, map.getOrDefault(c2, 0) + score);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<4; i++) {
            int count1 = map.get(types[i][0]);
            int count2 = map.get(types[i][1]);
            char c = count1 > count2 ? types[i][0] : count1 == count2 ? pick(types[i][0], types[i][1]) : types[i][1]; 
            sb.append(c);
        }
        
        
        return sb.toString();
    }
    
    public char pick(char a, char b) {
        if(a >= b) return b;
        else return a;
    }
    
}