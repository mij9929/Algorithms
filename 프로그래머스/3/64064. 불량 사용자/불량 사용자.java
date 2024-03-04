import java.util.*;


class Solution {
    static ArrayList<String> ansList = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;
    public boolean checkDuplicated(String str){
        for(int i=0; i<ansList.size(); i++){
            if(ansList.get(i).equals(str)) return false;
        }
        return true;
    }
    public boolean isSame(String str1, String str2){
        int len = str1.length();
        if(str1.length() != str2.length()) return false;
        for(int i=0; i<len; i++){
            if(str2.charAt(i) == '*') continue;
            if(str1.charAt(i) != str2.charAt(i)) return false;
        }
        
        return true;
    }
    
    public void dfs(int depth, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            if(checkDuplicated(Arrays.toString(visited))){
                ansList.add(Arrays.toString(visited));
                 ans++;
            }
            return ;
        }    
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(isSame(user_id[i], banned_id[depth])){
                    dfs(depth+1, user_id, banned_id);
                }
                visited[i] = false;
            }
        }
    }
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(0, user_id, banned_id);
        return ans;
    }
}