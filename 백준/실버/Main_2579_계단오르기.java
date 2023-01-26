import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int dp[] = new int[n+1];
		int st[] = new int[n];
		
		for(int i = 0; i<n; i++) {
			st[i] = Integer.parseInt(bf.readLine());
		}
		
		dp[0] = 0; 
		dp[1] = st[0];
		if(n >= 2) dp[2] = st[1] + st[0];
		for(int i = 3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + st[i-2]) + st[i-1];
		}
		
		System.out.println(dp[n]);
	}

}
