
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Integer> mulititabs = new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(num);
		}

		int count = 0;
		while (!arr.isEmpty()) {
			int num = arr.get(0);
//			 System.out.println(arr);
//			 System.out.println(mulititabs);
//			 System.out.println("==");
			if (mulititabs.contains(Integer.valueOf(num))) { // 현재 플러그에 꽂혀있으면 continue
				arr.remove(Integer.valueOf(num));
				continue;
			}

			if (mulititabs.size() < n) { // 플러그가 남아있으면 멀티탭에 추가
				mulititabs.add(num);
				arr.remove(Integer.valueOf(num));
				continue;
			}

			else {
				boolean flag = false;

				for (Integer multitab : mulititabs) {
					if (arr.contains(multitab))
						continue;
					else {
						mulititabs.remove(multitab);
						mulititabs.add(num);
						arr.remove(Integer.valueOf(num));
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					arr.remove(Integer.valueOf(num));
					int lastuse = 0;
					for(int i=0; i<n; i++) {
						if(lastuse < arr.indexOf(mulititabs.get(i)))
							lastuse = arr.indexOf(mulititabs.get(i));
					}
					mulititabs.remove(Integer.valueOf(arr.get(lastuse)));
					mulititabs.add(num);
					
				}
				count++;
			}
		}
		System.out.println(count);
	}
}
