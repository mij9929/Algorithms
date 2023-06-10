//package baekjoon.baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		public int idx;
		public int val;
		
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Deque<Node> deque = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int val = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().val > val) {
				deque.removeLast();
			}
			
			deque.add(new Node(i, val));
			
			if(deque.getFirst().idx <= i-L) {
				deque.removeFirst();
			}
			
			bw.write(deque.getFirst().val + " ");
		}
		
		bw.flush();
		bw.close();
		
	}
}
