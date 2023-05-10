import java.io.*;
import java.util.*;

public class Main {
   static int R, C, cnt, MAX, totalCnt;
   static boolean flag;
   static Queue<int[]> queue;
   static int[][] arr, dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
   static boolean[][][] visit;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      arr = new int[R][C];
      visit = new boolean[R][C][10];
      MAX = Integer.MIN_VALUE;
      queue = new LinkedList<>();

      for (int r = 0; r < R; r++) {
         String str = br.readLine();

         for (int c = 0; c < C; c++) {

            arr[r][c] = str.charAt(c) - '0';

            if (arr[r][c] > MAX)
               MAX = arr[r][c]; // 최대 높이 구하기

         }
      }

      System.out.println(solve());

   }

   static int solve() {

      for (int h = 2; h <= MAX; h++) {
         for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
               // 방문하지 않고 물이 고일 수 있다면 bfs 돌리기

               if (visit[r][c][h])
                  continue;

               if (arr[r][c] < h) {
                  cnt = 1;
                  queue.offer(new int[] { r, c });
                  visit[r][c][h] = true;
                  totalCnt += bfs(h);
               }

            }
         }
      }

      return totalCnt;
   }

   static int bfs(int h) {

      flag = true;

      out: while (!queue.isEmpty()) {

         int size = queue.size();
         int[] now = queue.poll();

         for (int d = 0; d < 4; d++) {
            int nr = now[0] + dir[d][0];
            int nc = now[1] + dir[d][1];

            if (!available(nr, nc)) {
               flag = false;
               continue;
            }
            
            if (visit[nr][nc][h])
               continue;

            
            if (available(nr, nc) && arr[nr][nc] < h) {
               queue.offer(new int[] { nr, nc });
               visit[nr][nc][h] = true;
               cnt++;
            }

            // 범위를 벗어난다면 물이 고일 수 없음

         }

      }
      

      if (flag)
         return cnt; // 물이 고일 때만 cnt 리턴
      else
         return 0;

   }

   static boolean available(int nr, int nc) {
      return nr >= 0 && nr < R && nc >= 0 && nc < C;
   }

}