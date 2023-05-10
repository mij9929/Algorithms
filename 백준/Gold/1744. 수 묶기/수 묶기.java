import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int sum = 0;
		int temp = 0;
		for (int i = 0; i < n && arr[i] <= 0; i++) {
			if (i + 1 < n && arr[i + 1] <= 0) {
				if (arr[i] + arr[i + 1] < arr[i] * arr[i + 1]) {
					temp = arr[i + 1] * arr[i];
					i++;
				} else
					temp = arr[i];
			} else
				temp = arr[i];

			sum += temp;
			temp = 0;
		}

		for (int j = n - 1; j > -1 && arr[j] > 0; j--) {
			if (j - 1 > -1 && arr[j - 1] > 0) {
				if (arr[j] + arr[j - 1] < arr[j] * arr[j - 1]) {
					temp = arr[j] * arr[j - 1];
					j--;
				} else {
					temp = arr[j];
				}
			} else {
				temp = arr[j];
			}
			sum += temp;
			temp = 0;
		}

		System.out.println(sum);
	}
}
