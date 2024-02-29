import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;

	public static int find(int a) {
		if (arr[a] == a)
			return a;
		else
			return arr[a] = find(arr[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b)
			arr[b] = a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n + 1];

		for (int i = 0; i <= n; i++)
			arr[i] = i; 
		int[][] graph = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j] == 1)
					union(i, j);
			}
		}
		
		int[] brr = new int[m+1];
		
		for(int i=1; i<=m; i++) {
			brr[i] = sc.nextInt();
		}	
		int node = find(brr[1]);
		boolean flag = true;
		for(int i=1; i<=m; i++) {
			if(find(brr[i]) != node) flag = false;
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");

	}
}
