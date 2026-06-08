import java.util.*;

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(computers[i][j] != 0)
                    union(i, j);
            }
        }
        
    HashSet<Integer> result = new HashSet<>();

    for (int i = 0; i < n; i++) {
        result.add(find(i));
    }
        
        return result.size();
    }
    
    public int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        
        parent[a] = find(parent[a]);
        return parent[a];
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
}