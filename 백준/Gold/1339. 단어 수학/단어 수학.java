import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		
		int[] alphabets = new int[27];
		
		while(count > 0) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int index = word.length()-1;
			int digit = 1;
			
			for(int i = index; i>=0; i--) {
				int alphabet = (int)(word.charAt(i) - 'A');
				alphabets[alphabet] += digit;
				digit *= 10;
			}
			
			count--;
		}
		
		Arrays.sort(alphabets);
		int total = 0;
		int size = 9;
		for(int i = 26; i>=0; i--) {
			total += alphabets[i] * size;
			size--;
		}
		
		System.out.println(total);
	}
}
