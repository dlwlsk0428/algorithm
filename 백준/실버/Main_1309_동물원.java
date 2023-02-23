import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1309_동물원 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 3;
		for(int i = 2; i<=n; i++) {
			dp[i] = (2*dp[i-1] + dp[i-2]) % 9901;
		}

		System.out.println(dp[n]);
	}
}
