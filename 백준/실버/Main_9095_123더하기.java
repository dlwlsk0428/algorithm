import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++) {
			int n = Integer.parseInt(bf.readLine());
			
			int dp[] = new int[n+1];
			dp[0] = 1;
			for(int i = 0; i<n; i++) {
				for(int j = 1; j<=3; j++) {
					if(i+j <= n) dp[i+j] += dp[i];
				}
			}
			
			System.out.println(dp[n]);
		}

	}
}
