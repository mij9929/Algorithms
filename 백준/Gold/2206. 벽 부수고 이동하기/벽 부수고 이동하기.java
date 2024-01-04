import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans = Integer.MAX_VALUE;

	static class Node {
		int x, y, d;
		int count;

		public Node(int x, int y, int d, int count) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}

		bfs(0, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j, 1, 1));
		visited[i][j][1] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == n - 1 && now.y == m - 1) {
				ans = Math.min(ans, now.d);
			}
			for (int k = 0; k < 4; k++) {
				int x = now.x + dx[k];
				int y = now.y + dy[k];
				int d = now.d + 1;
				int count = now.count;
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (!visited[x][y][count] && map[x][y] != 1) {
						visited[x][y][count] = true;
						queue.add(new Node(x, y, d, count));
					}

					if (count > 0) {
						if (!visited[x][y][count] && map[x][y] == 1) {
							visited[x][y][count] = true;
							queue.add(new Node(x, y, d, count-1));
						}
					}
				}
			}
		}
	}
}
