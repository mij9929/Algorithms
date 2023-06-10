//package baekjoon.baek;

import java.util.*;
import java.io.*;

public class Main {

	static int n, m, K;
	static int x1, y1, x2, y2;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans;

	static class Node {
		int x, y, value;

		public Node(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", value=" + value + "]";
		}

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[n+1][m+1];
		visited = new int[n+1][m+1];
		
		for(int[] vis: visited)
			Arrays.fill(vis, Integer.MAX_VALUE);		
		
		for (int i = 1; i < n+1; i++) {
			String s = br.readLine();
			for (int j = 1; j < m+1; j++) {
				map[i][j] = s.charAt(j-1);
			}
		}
		
		 st = new StringTokenizer(br.readLine());

		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		bfs(x1, y1);

		if(ans != Integer.MAX_VALUE)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i,j,0));
		ans = Integer.MAX_VALUE;
		visited[i][j] = 0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
//			System.out.println(now.toString());
			if(now.x == x2 && now.y == y2) {
				ans = Math.min(ans, now.value);
			}
			for(int k=0; k<4; k++) {
				for(int l=1; l<=K; l++) {
					int x = now.x + dx[k] * l;
					int y = now.y + dy[k] * l;
					int v = now.value+1;
					
					if(x > 0 && y>0 && x <= n && y<=m) {
						if(map[x][y] == '#') break;
                        if(visited[x][y] < v) break;
						if(map[x][y] == '.' && visited[x][y] > v) {
//							System.out.println("x=" + x + " " + "y=" + y + " " + "v=" + v);
							visited[x][y] = v;
							queue.add(new Node(x,y,v));
						}
					}
				}
			}
			
		}
	
	}
}
