import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int maxDp[][] = new int[n+1][3];
		int minDp[][] = new int[n+1][3];
		int board[][] = new int[n+1][3];
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<3; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];
            
            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];	
		}
		
        int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[n][i]);
            min = Math.min(min, minDp[n][i]);
        }
        System.out.println(max + " " + min);
	}

}
