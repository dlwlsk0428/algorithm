import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11727_2n타일링2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}

		System.out.println(dp[n]);
	}
}
