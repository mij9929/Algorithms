import java.util.*;
import java.lang.*;


class Solution {
    
    public int[] parent;
    public int diff = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<wires.length; i++) {
            int[] newParent = new int[n+1];
            
            for(int k=1; k<=n; k++) {
                newParent[k] = k;
            }
            
            for(int j=0; j<wires.length; j++) {
                if(j == i) continue;
                
                int from = wires[j][0];
                int to = wires[j][1];
                union(from, to, newParent);
            }
            
            int num1 = newParent[1];
            int c1 = 0, c2 =0;
            for(int k=1; k<=n; k++) {
                if(num1 == find(newParent[k], newParent)) c1++;
                else c2++;
            }
            
            answer = Math.min(answer, diff(c1,c2));
        }
        
        return answer;
    }
    
    public void union(int x, int y, int[] newParent) {
        int a = find(x, newParent);
        int b = find(y, newParent);
        
        if(a <= b) newParent[b] = a;
        else newParent[a] = b;
    }
    
    public int find(int x, int[] newParent) {
        if(x == newParent[x]) return x;
        return newParent[x] = find(newParent[x], newParent);
    }
    
    public int diff(int a, int b) {
        if(a >= b) return a-b;
        return b-a;
    }
}