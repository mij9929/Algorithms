import java.util.*;
class Solution {
    public static boolean[] visited;
    public static int min = 51;
    public boolean isConverted(String word1, String word2){
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false; 
            }
        }
        return diffCount == 1; 
        
    }
    public void dfs(String begin, String target, String[] words, int depth){
        if(begin.equals(target)){
            if(min > depth) min = depth;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(isConverted(begin, words[i])){
                    dfs(words[i], target, words, depth+1);
                }
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
         Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0; 
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return min;
    }
}