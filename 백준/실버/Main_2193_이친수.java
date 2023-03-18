import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2193_이친수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		long dp[] = new long[n+1];
		if(n == 1) System.out.println(1);
		else {
			dp[1] = 1;
			dp[2] = 1;
			
			for(int i = 3; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			
			System.out.println(dp[n]);
		}
	}
}
