import java.util.*;
import java.io.*;

public class Main {
	static int reverseFlag;
	static int sPos;
	static int ePos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(st.nextToken());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			String commands = st.nextToken();

			reverseFlag = 1;

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			String stringArr = st.nextToken();

			int len = stringArr.length();
			int idx = 0;
			for (int i = 1; i < len - 1; i++) {
				if (stringArr.charAt(i) != ',') {
					arr[idx] *= 10;
					arr[idx] += stringArr.charAt(i) - 48;
				} else
					idx++;
			}

			sPos = 0;
			ePos = arr.length;
			

			int commandLen = commands.length();
			boolean errorFlag = false;

			for (int i = 0; i < commandLen; i++) {
				if (commands.charAt(i) == 'R') {
					reverseFlag *= -1;
				} else if (commands.charAt(i) == 'D') {
					if (sPos >= ePos || n == 0) {
						errorFlag = true;
						break;
					}
					deleted();
				}
			}

			if (errorFlag)
				System.out.println("error");
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(reverseFlag == 1) {
					for(int i=sPos; i<ePos; i++) {
						sb.append(arr[i]);
						if(i != ePos-1) {
							sb.append(",");
						}
					}
				}
				else {
					for(int i=ePos-1; i>=sPos; i--) {
						sb.append(arr[i]);
						if(i != sPos) {
							sb.append(",");
						}
					}
				}
				
				sb.append("]\n");
				
				bw.append(sb);
				bw.flush();
			}

			T--;
		}
	}

	public static void deleted() {
		if (reverseFlag == -1) {
			ePos--;
		} else
			sPos++;
	}
}
