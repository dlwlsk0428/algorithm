import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 스타트와 링크
 */
public class Main_14889_스타트와링크 {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int S[][] = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean start[] = new boolean[N];
		team(0, 0, S, start);
		
		System.out.println(min);
	}
	
	static void team(int n, int i, int S[][], boolean start[]) {
		if(min == 0) return;
		if(i == start.length) return;
		if(n == start.length / 2) {
			int sstats = 0, lstats = 0;
			for(int j = 0; j<n*2; j++) {
				for(int k =0; k<n*2; k++) {
					if(j == k) continue;
					if(start[j] && start[k]) sstats += S[j][k];
					if(!start[j] && !start[k]) lstats += S[j][k];
				}
			}
			min = Math.min(Math.abs(sstats - lstats), min);
			return;
		}
		
		start[i] = true;
		team(n+1, i+1, S, start);
		start[i] = false;
		team(n, i+1, S, start);
	}

}
