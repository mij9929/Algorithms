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
		
		int n  =  Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] indegree = new int[n+1]; //진입 차수 배열
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
			indegree[e]++; // 진입 차수 배열 데이터 저장
		}
		
		Queue<Integer> queue = new LinkedList<>(); //위상정렬 수행
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int next : graph.get(now)){
				indegree[next]--;
				if(indegree[next] == 0)
					queue.offer(next);
			}
		}	
	}
}
