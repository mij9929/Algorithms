import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int cnt = 0;
	static boolean[][] visited;
	static int[][] arr;
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { 1, 0, -1, 0 };
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					q.offer(new int[] {i,j});
			}
		}

		BFS();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				if (arr[i][j] == 1 && !visited[i][j]) {
//					BFS(i, j);
//				}
//			}
//		}

		int flag = 0; // 0 정상, -1 안됨
		int day = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					flag = -1;
				if (day < arr[i][j]) {
					day = arr[i][j];
				}
			}
		}

//		for (int[] is : arr) {
//			System.out.println(Arrays.toString(is));
//		}

		if (flag == -1)
			System.out.println("-1");
		else
			System.out.println(day - 1);

	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dirX[k];
				int y = now[1] + dirY[k];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (arr[x][y] != -1 && !visited[x][y]) {
						visited[x][y] = true;
						if (arr[x][y] == 0)
							arr[x][y] = arr[now[0]][now[1]] + 1;
						q.add(new int[] { x, y });
					}
				}
			}
		}
	}

}
