import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int miro[][] = new int[n+1][m+1];
		int dp[][] = new int[n+1][m+1];

		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=m; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		boolean check[][] = new boolean[n+1][m+1];
		int dir[][] = new int[][] {{1, 0}, {0, 1}, {1, 1}};
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				for(int d = 0; d < dir.length; d++)
					dp[i][j] = Math.max(dp[i-dir[d][0]][j-dir[d][1]] + miro[i][j], dp[i][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
