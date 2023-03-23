import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int P[] = new int[N+1];
		int dp[] = new int[N+1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++) P[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<=N; j++) {
				if(i+j <= N) dp[i+j] = Math.max(dp[i+j], dp[j] + P[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
