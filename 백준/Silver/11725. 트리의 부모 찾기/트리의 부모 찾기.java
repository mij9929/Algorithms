
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		tree = new ArrayList[n+1];
		answer = new int[n+1];
		for(int i=0; i<n+1; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		dfs(1);
		
		
		for(int i=2; i<n+1; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		for(int i : tree[n]) {
			if(!visited[i]) {
				answer[i] = n;
				dfs(i);
				
			}
		}
	}
}
