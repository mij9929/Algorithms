import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i=0; i<=n; i++) arr[i] = i;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int opt = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(opt == 0) union(a,b);
			else print(a, b);
		}
	}
	private static void print(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) System.out.println("YES");
		else System.out.println("NO");
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		arr[b] = a;
	}
	
	private static int find(int a) {
		if(arr[a] == a) return a;
		else return arr[a] = find(arr[a]);
	}
}
