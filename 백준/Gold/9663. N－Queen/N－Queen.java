import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        n_queen(0);
        System.out.println(answer);

    }
    private static void n_queen(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for(int col =0; col<n; col++){
            if(isSafe(row, col)) {
                board[row] = col;
                n_queen(row+1);
            }
        }

    }

    private static boolean isSafe(int row, int col) {
        for(int prevRow = 0; prevRow < row; prevRow++){
            int prevCol = board[prevRow];
            if(prevCol == col || Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }
        return true;
    }


}