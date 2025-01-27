import java.util.*;

class Solution {
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};
    public static boolean[][] visited;
    public static Queue<Node> queue = new LinkedList<>();
    public static class Node {
        int x, y, v;

        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public int bfs(String[] board, int n, int m) {
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (board[now.x].charAt(now.y) == 'G') {
                answer = Math.min(answer, now.v);
                continue; // 목표지점에 도달했으므로 탐색을 이어감
            }

            for (int k = 0; k < 4; k++) {
                int x = now.x;
                int y = now.y;

                // 해당 방향으로 끝까지 이동
                while (true) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx].charAt(ny) == 'D') {
                        break;
                    }
                    x = nx;
                    y = ny;
                }

                // 이동한 위치가 방문되지 않았으면 추가
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, now.v + 1));
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        visited = new boolean[n][m];

        // 시작 지점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        return bfs(board, n, m);
    }
}
