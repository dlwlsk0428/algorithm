import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static int d[][] = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static boolean[][] map;
	static int R, C;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) == '.' ? true : false;
			}
		}

		int answer = 0;
		for(int i = 0; i<R; i++) {
			if(gas(i, 0)) answer++;
		}
		System.out.println(answer);
	}
	
	static boolean gas(int x, int y) {
		for(int i = 0; i<d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(map[nx][ny]) {
					map[nx][ny] = false;
					if(ny == C- 1) return true;
					if(gas(nx, ny)) return true;
				}
			}
		}
		
		return false;
	}

}
