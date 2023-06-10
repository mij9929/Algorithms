import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	//https://www.acmicpc.net/board/view/50558
	static char[][] map;
	static int rmap[][];
	static int bmap[][];
	static boolean visited[][][][];
	static int n, m;
	static int ex, ey;
	static int ans = -1;
	static int[] dx = new int[] { 0, 0, -1, 1 }; // 좌, 우, 상 , 하
	static int[] dy = new int[] { -1, 1, 0, 0, };
	static Queue<Node> rQueue = new LinkedList<>();
	static Queue<Node> bQueue = new LinkedList<>();

	static class Node {
		int x, y, v;

		public Node() {
			this.v = -1;
		}

		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", v=" + v + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		rmap = new int[n][m];
		bmap = new int[n][m];
		visited = new boolean[n][m][n][m];
		ex = 0;
		ey = 0;
		
		int bsx=0,bsy=0;
		int rsx=0,rsy=0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'B') {
					bQueue.add(new Node(i, j, 0));
					bsx =i;
					bsy=j;
				}
				if (map[i][j] == 'R') {
					rQueue.add(new Node(i, j, 0));
					rsx=i;
					rsy=j;
				}
				if (map[i][j] == 'O') {
					ex = i;
					ey = j;
				}
			}
		}
		visited[rsx][rsy][bsx][bsy] = true;
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		while (!rQueue.isEmpty() && !bQueue.isEmpty()) {
			Node rNow = rQueue.poll();
			Node bNow = bQueue.poll();	
			
			if (rNow.v > 10) {
				 ans = -1;
				 break;
				 
			}
			
			if (bNow.x == ex && bNow.y == ey) {
				continue;
			}

			else if (rNow.x == ex && rNow.y == ey) {
				ans =  rNow.v;
				break;
			}

			for (int k = 0; k < 4; k++) {
				int rx = rNow.x;
				int ry = rNow.y;
				int rv = rNow.v + 1;

				while (true) {
					rx += dx[k];
					ry += dy[k];

					if (rx >= 0 && ry >= 0 && rx < n && ry < m ) {
						rmap[rx][ry] = rv;
						if (map[rx][ry] == 'O') {
							rmap[rx][ry] = rv;
							break;
						}

						else if (map[rx][ry] == '#') {
							rx = rx - dx[k];
							ry = ry - dy[k];
							break;
						}
						
						rmap[rx][ry] = rv;
					}
				}

				int bx = bNow.x;
				int by = bNow.y;
				int bv = bNow.v + 1;

				while (true) {
					bx += dx[k];
					by += dy[k];
					if (bx >= 0 && by >= 0 && bx < n && by < m ) {
						if (map[bx][by] == 'O') {
							bmap[bx][by] = bv;
							break;
						}

						else if (map[bx][by] == '#') {
							bx = bx - dx[k];
							by = by - dy[k];
							break;
						}
					}
				}

				if (rx == bx && ry == by && map[rx][ry] != 'O') {
					int rdis = Math.abs(rx - rNow.x) + Math.abs(ry - rNow.y);
					int bdis = Math.abs(bx - bNow.x) + Math.abs(by - bNow.y);
					if (rdis > bdis) {
						rx -= dx[k];
						ry -= dy[k];
					} else {
						bx -= dx[k];
						by -= dy[k];
					}
				}

				if (!visited[rx][ry][bx][by]) {
					rQueue.add(new Node(rx, ry, rv));
					bQueue.add(new Node(bx, by, bv));
					visited[rx][ry][bx][by] = true;
				}

	

			}
		}
		//return -1;
	}
}
