
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long[] arr = new long[n + 1];

		long[] namujiArr = new long[m];
		long count = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
		}

		for (int i = 1; i <= n; i++) {
			arr[i] += arr[i - 1];
		}

		// 1 2 3 1 2
		// 1 3 6 7 9
		// 1 0 0 1 0
		for (int i = 1; i <= n; i++) {
			if (arr[i] % m == 0) { // 1 3 6 7 9, 연속합(0 ~ j)까지의 합 중 %m =0 값 추출
				count++;
			}
			long namuji = (long) (arr[i] % m);
			namujiArr[(int) namuji]++;
		}

		for (int i = 0; i < m; i++) {
			if (namujiArr[i] > 1)
				count += (namujiArr[i] * (namujiArr[i] - 1) / 2);
		}

		System.out.println(count);


	}
}
