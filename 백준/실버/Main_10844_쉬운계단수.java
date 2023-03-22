
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		long mod = 1000000000;
		long dp[][] = new long[n+1][10];
		
		for(int i = 1; i<10; i++) dp[1][i] = 1;
		for(int i = 2; i<dp.length; i++) {
			dp[i][0] = dp[i-1][1] % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod;
			dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % mod;
			dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % mod;
			dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % mod;
			dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % mod;
			dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % mod;
			dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % mod;
			dp[i][9] = dp[i-1][8] % mod;
		}
		
		long num = 0;
		for(int i = 0; i<10; i++) {
			num += dp[n][i] % mod;
		}

		System.out.println(num % mod);
	}
}
