import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2302_극장좌석 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		boolean vip[] = new boolean[N+1];
		int dp[] = new int[N+1];
		
		for(int i = 0; i<M; i++) {
			vip[Integer.parseInt(bf.readLine())] = true;
		}
		
		dp[0] = dp[1] = 1;
		
		for(int i = 2; i<vip.length; i++) {
			if(vip[i] || vip[i-1]) dp[i] = dp[i-1];
			else dp[i] = dp[i-1] + dp[i-2];
		}
				
		System.out.println(dp[N]);
	}
}
