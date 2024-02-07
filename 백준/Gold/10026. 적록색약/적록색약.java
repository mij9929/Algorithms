import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char[][] arr;
	static boolean[][] visited;
	static int n;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { -0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int cnt1 = 0, cnt2 = 0;
		arr = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					BFS(i, j, arr[i][j]);
					cnt1++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					BFS(i, j, arr[i][j]);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1 +" " + cnt2);
	}

	private static void BFS(int i, int j, char color) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dX[k];
				int y = now[1] + dY[k];

				if (x >= 0 && y >= 0 && x < n && y < n) {
					if (!visited[x][y] && arr[x][y] == color) {
						visited[x][y] = true;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}
}
