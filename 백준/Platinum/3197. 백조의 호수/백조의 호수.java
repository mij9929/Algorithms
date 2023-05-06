import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static boolean swanflag = false;

	static char[][] map;
	static int[][] swan;

	static int sx, sy;

	static Queue<Node> water = new LinkedList<>();
	static Queue<Node> queue = new LinkedList<>();
	static Queue<Node> nextQueue = new LinkedList<>();
	static int ans = 0;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void iceToWater(int i, int j) { // 물과 인접한 얼음 -> 물로 변환
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && y >= 0 && x < n && y < m) {
				if (map[x][y] == 'X') {
					map[x][y] = '.';
					water.add(new Node(x, y));
				}
			}
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.x == swan[1][0] && now.y == swan[1][1]) {
				swanflag = true;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int x = now.x + dx[k];
				int y = now.y + dy[k];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (!visited[x][y]) {
						visited[x][y] = true;
						if (map[x][y] == 'X') { // 다음 출발점
							nextQueue.add(new Node(x, y));
						} else {
							queue.add(new Node(x, y));
						}
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

		map = new char[n][m];
		swan = new int[2][2];
		int swanIdx = 0;


		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'L') { // 백조 좌표 저장
					swan[swanIdx][0] = i;
					swan[swanIdx][1] = j;
					swanIdx++;
				}
				if (map[i][j] != 'X') { // 물 좌표 큐에 저장
					water.add(new Node(i, j));
				}
			}
		}

		sx = swan[0][0]; // 시작좌표(첫번째 백조 좌표)
		sy = swan[0][1];

		queue.add(new Node(sx, sy)); // 초기 시작 bfs 
		visited = new boolean[n][m];
        
		while (true) {
			nextQueue = new LinkedList<>(); // 다음 시작 지점 큐
			bfs();
			if (swanflag) // 백조 만나면 종료
				break;

			int size = water.size();
			for (int i = 0; i < size; i++) {
				Node now = water.poll();
				iceToWater(now.x, now.y);
			}
			ans++;
			queue = nextQueue; // 다음 시작점 저장
		}

		System.out.println(ans);

	}
}
