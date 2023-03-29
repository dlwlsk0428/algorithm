import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2631_줄세우기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int dp[] = new int[n+1];
		int num[] = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			num[i] = Integer.parseInt(bf.readLine());
		}
		
		dp[0] = 0;
		int answer = 0;
		for(int i = 1; i<=n; i++) {
			dp[i] = 1;
			for(int j = 1; j<=n; j++) {
				if(num[j] < num[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			answer = Math.max(answer, dp[i]);
		}
		
//		for(int i = 1; i<=n; i++) System.out.println(dp[i]);
		
		System.out.println(n - answer);
	}
}
