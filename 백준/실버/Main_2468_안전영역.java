import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	public static boolean check[][];
	public static int map[][];
	public static int dir[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		
		int max = -1;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		for(int i = 0; i<=max; i++) {
			check = new boolean[map.length][map.length];
			int area = 0;
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<n; k++) {
					if(!check[j][k] && map[j][k] > i) area += find(j, k, i);
				}
			}
			answer = Math.max(answer, area);
		}
		
		System.out.println(answer);
	}
	
	public static int find(int x, int y, int rain) {
		check[x][y] = true;
		for(int i = 0; i<dir.length; i++) {
			int nx = x + dir[i][0], ny = y + dir[i][1];
			if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && !check[nx][ny] && map[nx][ny] > rain) {
				find(nx, ny, rain);
			}
		}
		
		return 1;
	}
}
