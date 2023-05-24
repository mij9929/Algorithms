import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			boolean find =false;
			int start = 0;
			int end = n-1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				int midv = arr[mid];
				if(midv  > target) {
					end = mid - 1;
				}
				else if(midv < target) {
					start = mid + 1;
					
				}
				else {
					find = true;
					break;
				}
			}
			
			if(find) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
}
