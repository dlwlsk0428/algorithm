import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2011_암호코드 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		if(str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		long dp[] = new long[str.length() + 1];
		dp[0] = dp[1] = 1;
		
		for(int i = 2; i<=str.length(); i++) {
			char now = str.charAt(i-1);
			char pre = str.charAt(i-2);
			
			if(now == '0') {
				if(pre == '1' || pre == '2') dp[i] = dp[i-2] % 1000000;
				else {
					System.out.println(0);
					return;
				}
			} else {
				if(pre == '0') dp[i] = dp[i-1] % 1000000;
				else {
					int tmp = (pre - '0') * 10 + (now - '0');
					if(tmp < 0 || tmp > 27) dp[i] = dp[i-1] % 1000000;
					else dp[i] = (dp[i-2] + dp[i-1]) % 1000000;
				}
			}
		}
		
		System.out.println(dp[str.length()] % 1000000);
	}

}
