import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] wv = new int[n][2];
		int[] dp = new int[k+1];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i= 0; i<n; i++) {
			for(int j = k; j >= wv[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - wv[i][0]] + wv[i][1]);
			}
		}
		
		for(int i = 0; i<dp.length; i++) System.out.println(i + " : " + dp[i]);
		
		System.out.println(dp[k]);
	}
}
