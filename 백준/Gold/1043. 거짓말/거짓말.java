

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] parent;
	static int[] truePeople;

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[b] = a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		int t = sc.nextInt();
		truePeople = new int[t];
		for (int i = 0; i < t; i++) {
			truePeople[i] = sc.nextInt();
		}

		ArrayList<Integer> party[] = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();
			int partySize = sc.nextInt();
			for(int j=0; j<partySize; j++) {
				int people = sc.nextInt();
				party[i].add(people);
			}
		}
		
		for(int i=0; i<m; i++) {
			int represent = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(represent, party[i].get(j));
			}
		}
		int ans = 0;
		for(int i=0; i<m; i++) {
			int represnt = party[i].get(0);
			boolean flag = false;
			for(int j=0; j<truePeople.length; j++) {
				if(find(represnt) == find(truePeople[j])) {
					flag = true;
					break;
				}	
			}
			if(!flag) ans++;
		}
		
		System.out.println(ans);
	}
	
}

