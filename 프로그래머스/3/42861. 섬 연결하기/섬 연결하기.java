import java.util.*;

class Edge {
    public int start;
    public int end;
    public int cost;
    
    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    public String toString() {
        return start + "-" + end + ", cost = " + cost + "\n";
    }
}

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        Edge[] edges = new Edge[costs.length];
        
        for(int i=0; i<costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            Edge edge = new Edge(start, end, cost);
            edges[i] = edge;
        }
        
        System.out.println(Arrays.toString(edges));
        
        return kruskal(n, edges);
    }
    
    private int kruskal(int n, Edge[] edges) {
        int result = 0;
        int selectedEdgeCount = 0;
        System.out.println(Arrays.toString(parent));
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.cost));
        
        for(Edge edge : edges) {
            int start = edge.start;
            int end = edge.end;
            int cost = edge.cost;

            if(find(start) != find(end)) {
                union(start,end);
                result += cost;
                selectedEdgeCount += 1;

                if(selectedEdgeCount == n - 1) break;
            }
        }
        
        return result;
    }
    
    private int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        
        parent[a] = find(parent[a]);
        return parent[a];
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    
}