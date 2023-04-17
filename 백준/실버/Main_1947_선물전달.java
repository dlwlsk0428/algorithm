import java.util.Scanner;

public class Main_1947_선물전달 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		
		long dp[] = new long[n+1];
		dp[0] = 0;
		dp[1] = 0;
		if(n >= 2) dp[2] = 1;
		
		for(int i = 3; i<=n; i++) dp[i] = ((i-1) * (dp[i-1] + dp[i-2])) % 1000000000;
		
		System.out.println(dp[n]);
	}

}
