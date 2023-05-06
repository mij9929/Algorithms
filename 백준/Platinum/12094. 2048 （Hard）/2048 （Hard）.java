//package baekjoon.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int ans=2;

	static int[][] move(int dir, int[][] arr) {
		if (dir == 0) { // left
			for (int i = 0; i < n; i++) {
				int tdx = 0;
				int flag = 0;
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0)
						continue;
					if (tdx > 0 && arr[i][tdx - 1] == arr[i][j] && flag == 0) {
						int temp = arr[i][j];
						arr[i][j] = 0;
						arr[i][tdx - 1] = temp * 2;
						flag = 1;
					} else {
						int temp = arr[i][j];
						arr[i][j] = 0;
						arr[i][tdx++] = temp;
						flag = 0;
					}

				}
			}
		}

		if (dir == 1) { // right
			for (int i = 0; i < n; i++) {
				int tdx = n - 1;
				int flag = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (arr[i][j] == 0)
						continue;
					if (tdx < n - 1 && arr[i][tdx + 1] == arr[i][j] && flag == 0) {
						int temp = arr[i][j];
						arr[i][j] = 0;
						arr[i][tdx + 1] = temp * 2;
						flag = 1;
					} else {
						int temp = arr[i][j];
						arr[i][j] = 0;
						arr[i][tdx--] = temp;
						flag = 0;
					}
				}
			}
		}

		if (dir == 2) { // up
			for (int i = 0; i < n; i++) {
				int tdx = 0;
				int flag = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 0)
						continue;
					if (tdx > 0 && arr[tdx - 1][i] == arr[j][i] && flag == 0) {
						int temp = arr[j][i];
						arr[j][i] = 0;
						arr[tdx - 1][i] = temp * 2;
						flag = 1;
					} else {
						int temp = arr[j][i];
						arr[j][i] = 0;
						//System.err.println("j=" + j +"i=" + i + "tdx=" + tdx);
						arr[tdx++][i] = temp;
						flag = 0;
					}
				}
			}
		}

		if (dir == 3) { // down
			for (int i = 0; i < n; i++) {
				int tdx = n - 1;
				int flag = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] == 0)
						continue;
					if (tdx < n - 1 && arr[tdx + 1][i] == arr[j][i] && flag == 0) {
						int temp = arr[j][i];
						arr[j][i] = 0;
						arr[tdx + 1][i] = temp * 2;
						flag = 1;
					} else {
						int temp = arr[j][i];
						arr[j][i] = 0;
						arr[tdx--][i] = temp;
						flag = 0;
					}
				}
			}
		}

		return arr;
	}

	static void recursive(int count, int[][] arr) {
		if (count == 10) {
			find(arr);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int[][] tempMap = new int[n][n];
			for (int j = 0; j < n; j++) 
				tempMap[j] = arr[j].clone();
			
			move(i, tempMap);
			recursive(count + 1, tempMap);
		}
	}

	private static void find(int[][] arr) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}

		ans = Math.max(ans, max);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursive(0, map);
		
		System.out.println(ans);

	}
}
