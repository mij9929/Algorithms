
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> problems = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			problems.add(new ArrayList<>());
		}
		
		int[] degree = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int priorityNum = Integer.parseInt(st.nextToken());
			int afterNum = Integer.parseInt(st.nextToken());
			
			problems.get(priorityNum).add(afterNum);
			degree[afterNum]++;
			
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=1; i<=n; i++) {
			if(degree[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int next : problems.get(now)) {
				degree[next]--;
				if(degree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}
