import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {

	static int[][] arr;
	static int row, col, n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<n; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(k == 1) one();
			if(k == 2) two();
			if(k == 3) {arr = three(); two();}
			if(k == 4) {arr = four(); one();}
			if(k == 5) five();
			if(k == 6) six();
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void one() {
		int tmp;
		for(int i = 0; i<row/2; i++) {
			for(int j = 0; j<col; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[row -1 - i][j];
				arr[row -1 - i][j] = tmp;
			}
		}
	}
	
	static void two() {
		int tmp;
		for(int i = 0; i< row; i++) {
			for(int j = 0; j<col/2; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i][col -1 -j];
				arr[i][col -1 -j] = tmp;
			}
		}
	}
	
	static int[][] three() {
		int tmp;
		int [][] rotate = new int[col][row];
		for(int i = 0; i< row; i++) {
			for(int j = 0; j<col; j++) {
				rotate[j][i] = arr[i][j];
			}
		}
		tmp = row;
		row = col;
		col = tmp;
		return rotate;
	}
	
	static int[][] four() {
		int tmp;
		int [][] rotate = new int[col][row];
		for(int i = 0; i< row; i++) {
			for(int j = 0; j<col; j++) {
				rotate[j][i] = arr[i][j];
			}
		}
		tmp = row;
		row = col;
		col = tmp;
		return rotate;
	}
	
	// 1->2 2->3 3->4 4->1
	static void five() {
		int tmp;
		for(int i = 0; i< row/2; i++) {
			for(int j = 0; j<col/2; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i+row/2][j];
				arr[i+row/2][j] = arr[i+row/2][j+col/2];
				arr[i+row/2][j+col/2] = arr[i][j+col/2];
				arr[i][j+col/2] = tmp;
			}
		}
	}
	
	// 1->4 2->1 3->2 4->3
	static void six() {
		int tmp;
		for(int i = 0; i< row/2; i++) {
			for(int j = 0; j<col/2; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i][j+col/2];
				arr[i][j+col/2] = arr[i+row/2][j+col/2];
				arr[i+row/2][j+col/2] = arr[i+row/2][j];
				arr[i+row/2][j] = tmp;
			}
		}
	}
}