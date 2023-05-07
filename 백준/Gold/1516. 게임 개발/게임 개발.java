import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		int[] indegree = new int[n + 1]; // 진입차수 배열
		int[] selfBuild = new int[n + 1]; // 자기 건물 짓는시간

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken()); 
			while (true) {
				int preTemp = Integer.parseInt(st.nextToken()); // 이전 건물
				if (preTemp == -1)
					break;
				graph.get(preTemp).add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		int[] result = new int[n + 1];

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : graph.get(now)) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[now] + selfBuild[now]);
				if (indegree[next] == 0)
					queue.offer(next);
			}
		}

		for(int i=1; i<=n; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}
}
