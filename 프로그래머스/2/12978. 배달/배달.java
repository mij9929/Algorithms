import java.util.*;

class Edge {
    int to;
    int cost;
    
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Node {
    int vertex;
    int distance;
    
    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

class Solution {
    int[] distance;
    List<Edge>[] edges;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            
            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }
        
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentDistance = current.distance;
            
            if(currentDistance > distance[currentVertex]) continue;
            
            for(Edge edge: edges[currentVertex]) {
                int nextDistance = currentDistance + edge.cost;
                if(nextDistance < distance[edge.to]) {
                    distance[edge.to] = nextDistance;
                    pq.offer(new Node(edge.to, nextDistance));
                }
            }
            
        }
        
        
        for(int i=1; i<=N; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}