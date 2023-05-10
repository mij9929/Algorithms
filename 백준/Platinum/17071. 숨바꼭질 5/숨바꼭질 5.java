import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int n, m;
	static int[] map;

	static int ans = Integer.MAX_VALUE;
	static int[] dx = new int[] { -1, 1, 2 };
	static int len;

	static class Node {
		int x;
		int v;

		public Node(int x, int v) {
			this.x = x;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", v=" + v + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if (m >= 500001) {
			System.out.println(-1);
			return;
		}

		len = 500001;
		map = new int[len];
		visited = new boolean[len][2]; // 홀수 접근, 짝수 접근 

		Arrays.fill(map, -1);

		int time = 0;
		int pos = m;
		while (true) {
			pos = pos + time;
			if (pos >= 500001)
				break;
			map[pos] = time;
			
			time++;
		}
		
		
		bfs(n, m);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}

		else
			System.out.println(ans);
	}

	public static void bfs(int n, int m) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(n, 0));

		visited[n][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			
			if (map[now.x] > -1) {
				if (map[now.x] >= now.v && Math.abs(map[now.x] - now.v) % 2 == 0) {
					ans = Math.min(ans, map[now.x]);
				}
			}

			for (int k = 0; k < 3; k++) {
				int x = now.x;
				int v = now.v;

				if (k != 2) {
					x = now.x + dx[k];
				} else {
					x = now.x * 2;
				}

				if (x >= 0 && x < 500001) {
					if (!visited[x][v%2]) {
						queue.add(new  Node(x, v+1));
						visited[x][v%2] = true;
					}
				}
			}
		}

	}
}
