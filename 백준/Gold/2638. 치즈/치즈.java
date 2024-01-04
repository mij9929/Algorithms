//package baekjoon.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static ArrayList<int[]> melt = new ArrayList<>();
	static boolean[][] visited;
	static boolean[][] airVisited;
	static int ans = 0;
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };

	private static void airCheck(int i, int j) {
		int cnt = 0;
		int[] now = new int[] { i, j };
		for (int k = 0; k < 4; k++) {
			int x = now[0] + dirX[k];
			int y = now[1] + dirY[k];
			if (x >= 0 && y >= 0 && x < n && y < m) {
				if (arr[x][y] == 1 || arr[x][y] == 0)
					cnt++;
			}
		}
		if (cnt < 4) {
			arr[i][j] = -1;
		}
	}
	

	
	private static void airBfs(int i, int j) { // bfs 
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dirX[k];
				int y = now[1] + dirY[k];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (!airVisited[x][y] && arr[x][y] != 1) {
						airCheck(x, y);
						airVisited[x][y] = true;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}
	
	private static void meltCheck(int i, int j) {
		int cnt = 0;
		int[] now = new int[] { i, j };
	
		for (int k = 0; k < 4; k++) {
			int x = now[0] + dirX[k];
			int y = now[1] + dirY[k];
			if (x >= 0 && y >= 0 && x < n && y < m) {
				if (arr[x][y] == -1)
					cnt++;
			}
		}
		if (cnt >= 2)
			melt.add(now);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		meltCheck(i,j);
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dirX[k];
				int y = now[1] + dirY[k];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (!visited[x][y] && arr[x][y] == 1) {
						meltCheck(x, y);
						visited[x][y] = true;
						queue.add(new int[] { x, y });
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
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			visited = new boolean[n][m];
			airVisited = new boolean[n][m];
			melt.clear();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!airVisited[i][j])
						airBfs(i, j);
				}
			}
			
//			for(int is[] : arr) {
//				System.out.println(Arrays.toString(is));
//			}
//			System.out.println(ans + "==============");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && arr[i][j] == 1)
						bfs(i, j);
				}
			}
			
//			for(int is[] : arr) {
//				System.out.println(Arrays.toString(is));
//			}
//			System.out.println(ans + "=================");
			
			if(melt.isEmpty()) break;

			if (!melt.isEmpty()) {
				for (int[] mc : melt) {
					arr[mc[0]][mc[1]] = 0;
				}
			}
			ans++;

		}
		
		System.out.println(ans);
	}
}
