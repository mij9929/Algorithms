
import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int[][][] tetrominos = {
				{ { 1, 1, 1, 1 } }, 
				{ { 1, 1 }, { 1, 1 } }, 
				{ { 1, 1, 1 }, { 1, 0, 0 } },
				{ { 1, 1, 1 }, { 0, 1, 0 } }, 
				{ { 1, 0 }, { 1, 1 }, { 0, 1 } } 
			};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int[][] tetromino : tetrominos) {
			for (int rotation = 0; rotation < 4; rotation++) {
				tetromino = rotatedTetromino(tetromino);
				
				for (int i = 0; i <= n - tetromino.length; i++) {
					for (int j = 0; j <= m - tetromino[0].length; j++) {
						ans = Math.max(sumTetromino(tetromino, i, j), ans);
					}
				}
				
				 int[][] symTetromino = symmetriedTetromino(tetromino);
	                for (int i = 0; i <= n - symTetromino.length; i++) {
	                    for (int j = 0; j <= m - symTetromino[0].length; j++) {
	                        ans = Math.max(sumTetromino(symTetromino, i, j), ans);
	                    }
	                }
				
				
			}
		}

		System.out.println(ans);
	}

	public static int[][] rotatedTetromino(int[][] tetromino) {
		int rows = tetromino.length;
		int cols = tetromino[0].length;

		int[][] rotates = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				rotates[j][rows - i - 1] = tetromino[i][j];
			}
		}

		return rotates;
	}
	public static int[][] symmetriedTetromino(int[][] tetromino){
		int rows = tetromino.length;
		int cols = tetromino[0].length;
		
		int[][] symmetry = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				symmetry[i][cols-j-1] = tetromino[i][j];
			}
		}
		
		return symmetry;
	}

	public static int sumTetromino(int[][] tetromino, int row, int col) {
		int sum = 0;

		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < tetromino[0].length; j++) {
				if (tetromino[i][j] == 1) {
					sum += map[row + i][col + j];
				}
			}
		}

		return sum;
	}
	
	
}
