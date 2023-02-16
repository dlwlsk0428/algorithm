import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

	public static int map[][];
	public static boolean check[][];
	public static int dir[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n  = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		while(true) {	
			// 빙하 구역 세기
			int area = 0;
			check = new boolean[n][m];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] > 0 && !check[i][j]) area += dfs(i, j, n, m);
				}
			}
			
			if(area > 1) break;
			if(area == 0) {
				answer = 0;
				break;
			}
			
			// 빙하 녹음
			melt(n, m);
			answer++;
		}
		
		System.out.println(answer);
	}
	
	public static int dfs(int x, int y, int n, int m) {
		check[x][y] = true;
		
		for(int d = 0; d < dir.length; d++) {
			int nx = x + dir[d][0], ny = y + dir[d][1];
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] > 0 && !check[nx][ny]) {
				dfs(nx, ny, n, m);
			}
		}
		
		return 1;
	}
	
	public static void melt(int n, int m) {
		int[][] tmp = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 0;
				for(int d = 0; d < dir.length; d++) {
					int nx = i + dir[d][0], ny = j + dir[d][1];
					if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
						cnt++;
					}
				}
				tmp[i][j] = Math.max(0, map[i][j] - cnt);
			}
		}
		
		map = tmp;
	}
}
