
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2]; // 계산의 편의를 위해 배열 크기를 +2 해

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int totalCost = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i + 1] > arr[i + 2]) {
				int count = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
				totalCost += count * 5;
				arr[i] -= count;
				arr[i + 1] -= count;

				count = Math.min(arr[i], arr[i + 2]);
				totalCost += count * 7;
				arr[i] -= count;
				arr[i + 1] -= count;
				arr[i + 2] -= count;

			} else {
				int count = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				totalCost += count * 7;
				arr[i] -= count;
				arr[i + 1] -= count;
				arr[i + 2] -= count;

				count = Math.min(arr[i], arr[i + 1]);
				totalCost += count * 5;
				arr[i] -= count;
				arr[i + 1] -= count;

			}

			int count = Math.min(arr[i], arr[i + 1]);
			totalCost += count * 5;
			arr[i] -= count;
			arr[i + 1] -= count;

			count = arr[i];
			totalCost += count * 3;
			arr[i] -= count;

		}

		// 결과 출력
		System.out.println(totalCost);
	}
}
