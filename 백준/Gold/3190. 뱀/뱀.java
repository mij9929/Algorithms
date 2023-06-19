import java.util.*;
import java.io.*;

public class Main {
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 오른쪽, 아래, 왼쪽, 위

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][n + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			map[row][col] = 1; // 사과 위치의 값은 1
		}

		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());

		String[][] rotations = new String[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			String dir = st.nextToken();

			rotations[i][0] = time;
			rotations[i][1] = dir;

		}
		
		int time = 0;
		int rotationsIndex = 0;
		int nowdir = 0;

		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 1, 1 });
		map[1][1] = 2;

		while (true) {
			time++;
			int[] head = snake.getFirst();
			int nextRow = head[0] + dir[nowdir][0];
			int nextCol = head[1] + dir[nowdir][1];
			if (nextRow < 1 || nextCol < 1 || nextRow > n || nextCol > n) {
				break;
			}

			if (map[nextRow][nextCol] == 2) {
				break;
			}

			if (map[nextRow][nextCol] == 1) { // 사과를 먹은 경우
                map[nextRow][nextCol] = 2; // 뱀의 머리 이동
                snake.addFirst(new int[] { nextRow, nextCol });
            } else {
                map[nextRow][nextCol] = 2; // 뱀의 머리 이동
                snake.addFirst(new int[] { nextRow, nextCol });

                int[] tail = snake.removeLast();
                map[tail[0]][tail[1]] = 0; // 꼬리 자르기
            }

			if (rotationsIndex < l && Integer.parseInt(rotations[rotationsIndex][0]) == time) {
				if (rotations[rotationsIndex][1].equals("D")) { // 오른쪽
					nowdir = (nowdir + 1) % 4;
				} else
					nowdir = (nowdir + 3) % 4;
				rotationsIndex++;
			}
		}

		System.out.println(time);
	}

}
