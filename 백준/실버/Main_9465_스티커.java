import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(bf.readLine());
			int map[][] = new int[2][n+1];
			int answer = 0;
			
			for(int i = 0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 1; j<=n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int dp[][] = new int[2][n+1];
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for(int i = 2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}

	}

}
