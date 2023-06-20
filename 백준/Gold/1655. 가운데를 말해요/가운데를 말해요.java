import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> order = new PriorityQueue<>(); // 오름차순
		PriorityQueue<Integer> reverseOrder = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if(reverseOrder.size() == order.size())
				reverseOrder.offer(Integer.parseInt(st.nextToken()));
			else
				order.add(Integer.parseInt(st.nextToken()));
			
			if(reverseOrder.size() != 0 && order.size() !=0 && reverseOrder.peek() > order.peek()) {
				int rev = reverseOrder.poll();
				int ord = order.poll();
				
				reverseOrder.offer(ord);
				order.offer(rev);
			}
			
			bw.append(reverseOrder.peek() + "\n");
		}
		
		bw.flush();
	
	}
}
