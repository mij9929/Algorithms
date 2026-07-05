import java.util.*;

class Solution {
    public int[] weak;
    public int[] dist;
    public boolean[] humanVisited;
    public boolean[] visited;
    public int weakCount;
    public int[] extendedWeak;
    public boolean isFinish;
    // 조합 + dfs
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        this.weak = weak;
        this.dist = dist;
        humanVisited = new boolean[dist.length];
        visited = new boolean[n];
        extendedWeak = new int[weak.length*2];
        isFinish = false;
        
        for(int i=0; i<extendedWeak.length; i++) {
            if(i < weak.length)
                extendedWeak[i] = weak[i];
            else 
                extendedWeak[i] = weak[i%weak.length] + n;
        }
        
        for(int i=1; i<=dist.length; i++) {
            permutaion(new ArrayList<Integer>(), 0, i);
            if(isFinish) return i;
        }
        
        return -1;
    }
    
    public void permutaion(ArrayList<Integer> people, int depth, int peopleCount) {
        if(depth == peopleCount) {
            
            for (int start = 0; start < weak.length; start++) {
                if (check(people, start, peopleCount)) {
                    isFinish = true;
                }
            }
            
            return;
        }
        
        for(int i=0; i<dist.length; i++) {
            if(!humanVisited[i]) {
                humanVisited[i] = true;
                people.add(i);
                permutaion(people, depth+1, peopleCount);
                people.remove(people.size() - 1);
                humanVisited[i] = false;
            }
        }
    }
    
    public boolean check(ArrayList<Integer> people, int start, int peopleCount) {
        int idx = 0;
        int coverEnd = extendedWeak[start] + dist[people.get(idx)];
        
        for(int i = start; i < start + weak.length; i++) {
            
            if(extendedWeak[i] > coverEnd) {
                idx++;
                
                if(idx == peopleCount) return false;
                
                coverEnd = extendedWeak[i] + dist[people.get(idx)];
            }
        }
        
        return true;
    
    }
    
}