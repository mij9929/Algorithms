//package baekjoon.baek;
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Node> queue = new LinkedList<>();

	static class Node {
		int x, y, z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void bfs(int i, int j) {

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int x = now.x + dx[k];
				int y = now.y + dy[k];
				int z = now.z + 2;
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (map[now.x][now.y] == -2)
						continue;

					if (map[x][y] != -2 && map[x][y] != -1 && map[x][y] != 0 && map[x][y] > 2) {
						if (z % 2 == 1) {
							if (z + 1 == map[x][y])
								map[x][y] = -2;
						} else {
							if (z - 1 == map[x][y])
								map[x][y] = -2;
						}
						continue;
					}

					if (!visited[x][y] && map[x][y] != -1 && map[x][y] != -2) {
						visited[x][y] = true;
						map[x][y] = z;
						queue.add(new Node(x, y, z));
					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1 || map[i][j] == 2) {
					visited[i][j] = true;
					queue.add(new Node(i, j, map[i][j]));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					bfs(i, j);

				}
			}
		}

		int ans1 = 0, ans2 = 0, ans3 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -2)
					ans3++;
				else if (map[i][j] % 2 == 1)
					ans1++;
				else if (map[i][j] % 2 == 0 && map[i][j] > 0)
					ans2++;

			}
		}

		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}
}
