

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr = new char[5][5];
	static boolean[] visited = new boolean[25];
	static boolean[][] tmpVisited;
	static int ans = 0;
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };

	public static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sCount = 0;
			int[][] tmp = new int[5][5];
			int x = 0, y = 0;
			for (int i = 0; i < 25; i++) {
				if (visited[i]) {
					tmp[i / 5][i % 5] = 1;
					x = i / 5;
					y = i % 5;
					if (arr[i / 5][i % 5] == 'S')
						sCount++;
				}
			}

			if (sCount >= 4) {
				bfs(x, y, tmp);
			}
		}

		for (int i = start; i < 25; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(cnt + 1, i + 1);
				visited[i] = false;
			}
		}

	}

	private static void bfs(int i, int j, int[][] tmps) {
		tmpVisited = new boolean[5][5];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		tmpVisited[i][j] = true;
		int cnt = 1;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dirX[k];
				int y = now[1] + dirY[k];

				if (x >= 0 && y >= 0 && x < 5 && y < 5) {
					if (tmps[x][y] == 1 && !tmpVisited[x][y]) {
						queue.add(new int[] { x, y });
						tmpVisited[x][y] = true;
						cnt++;
					}
				}
			}
		}

		if (cnt ==7) {
			ans++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		combination(0, 0);

		System.out.println(ans);

	}
}
