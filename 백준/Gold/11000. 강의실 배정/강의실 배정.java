
import java.util.*;
import java.io.*;

public class Main {
	public static class Lesson implements Comparable<Lesson> {
		public int start;
		public int end;

		public Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lesson lesson) {
			return this.start - lesson.start;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Lesson> lessons = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Lesson les = new Lesson(start, end);
			lessons.add(les);
		}
				
		PriorityQueue<Integer> room = new PriorityQueue<>();
		Collections.sort(lessons);
		room.add(lessons.get(0).end);
	
		for (int i = 1; i < n; i++) {
            if (room.peek() <= lessons.get(i).start) {
                room.poll();
            }
            room.offer(lessons.get(i).end);

        }
		System.out.println(room.size());
	}
}
