import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2239_스도쿠 {

	static boolean flag;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int[9][9];
		Queue<int []> queue = new ArrayDeque<>();
		for(int i = 0; i<9; i++) {
			String line = bf.readLine();
			for(int j = 0; j<9; j++) {
				board[i][j] = line.charAt(j) - '0';
				if(board[i][j] == 0) queue.offer(new int[] {i, j});
			}
		}
		
		sudoku(0, board);
		
	}
	
	static boolean check(int r, int c, int[][] board) {
		boolean num[] = new boolean[10];
		for(int i = 0; i<9; i++) {
			if(board[i][c] == 0) continue;
			if(num[board[i][c]]) return false;
			else num[board[i][c]] = true;
		}
		
		num = new boolean[10];
		for(int i = 0; i<9; i++) {
			if(board[r][i] == 0) continue;
			if(num[board[r][i]]) return false;
			else num[board[r][i]] = true;
		}
		
		num = new boolean[10];
		int nr = (r / 3) * 3, nc = (c / 3) * 3;
		for(int i = nr; i<nr+3; i++) {
			for(int j = nc; j<nc+3; j++) {
				if(board[i][j] == 0) continue;
				if(num[board[i][j]]) return false;
				else num[board[i][j]] = true;
			}
		}
		
		return true;
	}
	
	static void sudoku(int n, int[][] board) {
		if(flag) return;
		if(n == 81) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		if(!check(n/9, n%9, board)) return;
		
		if(board[n/9][n%9] > 0) sudoku(n+1, board);
		else {
			boolean num[] = new boolean[10];
			int r = n/ 9, c = n% 9;
			for(int i = 0; i<9; i++) {
				num[board[i][c]] = true;
				num[board[r][i]] = true;
			}
			int nr = (r / 3) * 3, nc = (c / 3) * 3;
			for(int i = nr; i<nr+3; i++) {
				for(int j = nc; j<nc+3; j++) {
					num[board[i][j]] = true;
				}
			}
			for(int i = 1; i<=9; i++) {
				if(num[i]) continue;
				board[n/9][n%9] = i;
				sudoku(n+1, board);
				board[n/9][n%9] = 0;
			}
		}
		
	}

}
