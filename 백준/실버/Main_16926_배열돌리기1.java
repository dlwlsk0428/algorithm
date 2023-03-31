import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[row][col];
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌아갈 사각형의 수 
		int count = Math.min(row, col) / 2;
		for(int i=0; i<n; i++) { 
			for(int j=0; j<count; j++) { //라인들 전부 돌리기
				int temp = arr[j][j]; // 마지막자리 = 처음
				
				for(int k=j+1; k<col-j; k++)
					arr[j][k-1] = arr[j][k];
				
				for(int k=j+1; k<row-j; k++)
					arr[k-1][col-1-j] = arr[k][col-1-j];
				
				for(int k=col-2-j; k>=j; k--)
					arr[row-1-j][k+1] = arr[row-1-j][k];
				
				for(int k=row-2-j; k>=j; k--)
					arr[k+1][j] = arr[k][j];
				
				arr[j+1][j] = temp;
			}
		}
		
		for(int j=0; j<row; j++) {
			for(int k=0; k<col; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}
}
