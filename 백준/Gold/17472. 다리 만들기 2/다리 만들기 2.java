import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Dari implements Comparable<Dari> {
	int s, e, v;

	Dari(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(Dari o) {

		return this.v - o.v;
	}
}

public class Main {
	static int n, m;
	static int[][] map;
	static int cnt = 0;
	static boolean[][] visited;
	static int mapNum;
	static int[] dirX = { 1, 0, -1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static PriorityQueue<Dari> dariQueue;
	static int[] parent;

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		parent[b] = a;
	}

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		map[i][j] += cnt;
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dirX[k];
				int y = now[1] + dirY[k];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (!visited[x][y] && map[x][y] > 0) {
						map[x][y] += cnt;
						visited[x][y] = true;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}

	public static void makeDari(int mapNum) {
		int dariStart = 0;
		int dariEnd = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) { // 가로 다리
			flag = false;
			for (int j = 0; j < m; j++) {
				if (map[i][j] == mapNum) {
					dariStart = j;
					flag = true;
				}
				if (map[i][j] > 0 && map[i][j] != mapNum && flag) {
					dariEnd = j;
					flag = false;
					int len = dariEnd - dariStart - 1;
					if (len > 1) {
						dariQueue.add(new Dari(mapNum, map[i][j], len));
					}
					break;
				}
			}
		}
		for (int j = 0; j < m; j++) { // 세로 다리
			flag = false;
			for (int i = 0; i < n; i++) {
				if (map[i][j] == mapNum) {
					dariStart = i;
					flag = true;
				}
				if (map[i][j] > 0 && map[i][j] != mapNum && flag) {
					dariEnd = i;
					int len = dariEnd - dariStart - 1;
					if (len > 1) {
						dariQueue.add(new Dari(mapNum, map[i][j], len));
					}
					flag = false;
					break;
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
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		parent = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			parent[i] = i;
		}

		dariQueue = new PriorityQueue<>();

		for (int i = 1; i <= cnt; i++)
			makeDari(i);

		if (dariQueue.size() >= 1) {
			int useEdge = 0;
			int result = 0;
			while (!dariQueue.isEmpty()) {
				Dari dari = dariQueue.poll();
				if (find(dari.s) != find(dari.e)) {
					union(dari.s, dari.e);
					useEdge++;
					result += dari.v;
				}
			}

			boolean flag = true; // 모든 노드가 연결
			int tmp = find(parent[1]);
			for (int i = 1; i <= cnt; i++) {
				if (tmp != find(parent[i]))
					flag = false;
			}
			if (!flag)
				System.out.println(-1);
			else
				System.out.println(result);
		} else
			System.out.println(-1);

	}
}
