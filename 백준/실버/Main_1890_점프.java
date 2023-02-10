import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_점프 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int map[][] = new int[n][n];
		long dp[][] = new long[n][n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int dir[][] = new int[][] {{1, 0}, {0, 1}};
		
		dp[0][0] = 1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(map[i][j] == 0) continue;
				if(i + map[i][j] < n) dp[i+map[i][j]][j] += dp[i][j];
				if(j + map[i][j] < n) dp[i][j+map[i][j]] += dp[i][j];
			}
		}
		
		System.out.println(dp[n-1][n-1]);
	}
}
