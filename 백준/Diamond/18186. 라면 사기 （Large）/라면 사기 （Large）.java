
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		int[] arr = new int[n + 2]; // 계산의 편의를 위해 배열 크기를 +2 해
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long totalCost = 0;

		if (b < c) {
			for (int i = 0; i < n; i++) {
				int count = arr[i];
				totalCost += count * b;
				arr[i] -= count;
			}
		}

		else {
			for (int i = 0; i < n; i++) {
				if (arr[i + 1] > arr[i + 2]) {
					int count = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
					totalCost += count * (b + c);
					arr[i] -= count;
					arr[i + 1] -= count;

					count = Math.min(arr[i], arr[i + 2]);
					totalCost += count * (b + 2 * c);
					arr[i] -= count;
					arr[i + 1] -= count;
					arr[i + 2] -= count;

				} else {
					int count = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
					totalCost += count * (b + 2 * c);
					arr[i] -= count;
					arr[i + 1] -= count;
					arr[i + 2] -= count;

					count = Math.min(arr[i], arr[i + 1]);
					totalCost += count * (b + c);
					arr[i] -= count;
					arr[i + 1] -= count;

				}

				int count = Math.min(arr[i], arr[i + 1]);
				totalCost += count * (b + c);
				arr[i] -= count;
				arr[i + 1] -= count;

				count = arr[i];
				totalCost += count * b;
				arr[i] -= count;

			}
		}

		// 결과 출력
		System.out.println(totalCost);
	}
}
