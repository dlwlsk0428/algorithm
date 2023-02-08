import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		boolean check[][] = new boolean[n][m];
		
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int dir[][] = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			boolean flag = false;
			// 현재 위치 청소
			map[x][y] = -1;
			
			// 왼쪽 방향부터 탐색 진행
			for(int i = 1; i<=dir.length; i++) {
				int di = (d - i + 4) % 4;
				int a = x + dir[di][0], b = y + dir[di][1];
				if(a >= 0 && a < n && b >= 0 && b < m && map[a][b] == 0) {
					x = a; y = b; d = di;
					flag = true;
					break;
				}
			}
			
			// 청소할 곳 찾으면 전진
			if(flag) continue;
			
			// 후진
			x += dir[(d + 2) % 4][0];
			y += dir[(d + 2) % 4][1];
			
			// 후진할 수 없으면 작동 정지2
			if(map[x][y] == 1) break; 
		}
		
		int num = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == -1) num++;
			}
		}
		
		System.out.println(num);
	}
}
