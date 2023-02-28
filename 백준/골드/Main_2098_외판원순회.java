

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {

	public static int dp[][], W[][];
	public static int imp = 17 * 1000000 + 1;
	public static int max = 2 * imp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		W = new int[n][n];
		dp = new int[n][(1<<n) - 1];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], max);
		}
		
		System.out.println(find(0, 1, n));
	}
	
	public static int find(int city, int check, int n) {
		if(check == (1<<n) - 1) {
			if(W[city][0] == 0) return imp;
			
			return W[city][0];
		}
		
		if(dp[city][check] != max) return dp[city][check];
		
		for(int i = 0; i<n; i++) {
			if((check & (1 << i)) == 0 && W[city][i] != 0) {
				dp[city][check] = Math.min(dp[city][check], find(i, check | (1 << i), n) + W[city][i]);
			}
		}
		
		return dp[city][check];
	}
}
