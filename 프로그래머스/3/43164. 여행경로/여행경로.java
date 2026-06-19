import java.util.*;

class Solution {
    static class Edge {
        String to;
        boolean used;

        Edge(String to) {
            this.to = to;
            this.used = false;
        }
    }

    Map<String, List<Edge>> graph = new HashMap<>();
    List<String> path = new ArrayList<>();
    int ticketCount;

    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;

        // 1. 그래프 만들기
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Edge(to));
        }

        // 2. 각 출발지별 도착지를 사전순 정렬
        for (String key : graph.keySet()) {
            graph.get(key).sort((a, b) -> a.to.compareTo(b.to));
        }

        // 3. ICN에서 시작
        path.add("ICN");

        dfs("ICN", 0);

        return path.toArray(new String[0]);
    }

    public boolean dfs(String current, int usedCount) {
        // 모든 티켓을 사용한 경우
        if (usedCount == ticketCount) {
            return true;
        }

        // 현재 도시에서 출발하는 티켓이 없는 경우
        if (!graph.containsKey(current)) {
            return false;
        }

        for (Edge edge : graph.get(current)) {
            if (edge.used) {
                continue;
            }

            edge.used = true;
            path.add(edge.to);

            if (dfs(edge.to, usedCount + 1)) {
                return true;
            }

            path.remove(path.size() - 1);
            edge.used = false;
        }

        return false;
    }
}