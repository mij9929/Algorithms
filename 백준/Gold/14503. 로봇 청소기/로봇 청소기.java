import java.util.*;
import java.io.*;

public class Main {

	public static int n, m;
	public static int[][] arr;

	public static int[] dx = { -1, 0, 1, 0 }; // 북 동 남 서 방향 이동
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 북 0, 동 1, 남 2, 서 3
		int d = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		int clean = 2;
		while (true) {
			if (arr[r][c] == 0) { // 1번
				arr[r][c] = clean++;
				ans++;
			}

			boolean arroundCheck = false;
			int x = 0;
			int y = 0;

			for (int k = 0; k < 4; k++) {
				// 현재 바라보는 방향으로부터 회전
				d = (d + 3) % 4;
				x = r + dx[d];
				y = c + dy[d];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (arr[x][y] == 0) {
						r = x;
						c = y;
						arroundCheck = true;
						break;
					}
				}
			}

			if (arroundCheck)
				continue; // 주변 4칸 중 청소되지 않은 칸이 있으므로 1번으로 돌아감

			r = r + dx[(d + 2) % 4];
			c = c + dy[(d + 2) % 4];

			if (r < 0 || c < 0 || r >= n || c >= m)
				break;
			if (arr[r][c] == 1)
				break;

		}

		System.out.println(ans);

	}

}
