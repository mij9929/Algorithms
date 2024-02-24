import java.util.*;
import java.lang.Math;

class Solution {
    public static int[] lionScore = new int[11];
    public static int[] ans = new int[11];
    public static int max = -1;
    
    public int getScoreDiff(int n, int[] info){
        int lion = 0;
        int apeach = 0;
        for(int i=0; i<=10; i++){
            if(info[i] == 0 && lionScore[i] == 0) continue;
            if(info[i] >= lionScore[i]) apeach += 10 - i;
            else lion += 10 - i;
        }
        
        return lion - apeach;
    }
    
    public void dfs(int n, int[] info, int d, int start){
        if(d == n){
            int tmp = getScoreDiff(n, info);
            if(max < tmp){
                max = tmp;
                ans = lionScore.clone();
            }
            else if(max == tmp){
                for(int i=10; i>=0; i--){
                    if(lionScore[i] > ans[i]){
                        ans = lionScore.clone();
                        break;
                    }
                    else if(lionScore[i] < ans[i]){
                        break;
                    }
                }
            }
            return;
        }
        
        for(int i=start; i<=10; i++){
            if(lionScore[i] > info[i]) continue;
            lionScore[i] += 1;
            dfs(n, info, d+1, i);
            lionScore[i] -= 1;
            
        }    
        
    }
    
    public int[] solution(int n, int[] info) {
        dfs(n, info, 0, 0);
        if(max <= 0 ) return new int[] {-1};
        return ans;
    }
}