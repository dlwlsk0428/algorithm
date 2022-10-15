import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 16196KB 184ms
 */
public class Main_21611_마법사상어와블리자드 {

	public static int n, m;
	public static int map[][], movingMap[][], checkMap[][];
	public static int boom[];
	public static int dir[][] = new int[][] {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boom = new int[]{0, 0, 0, 0};
		
		map = new int[n][n];
		movingMap = new int[n][n];
		checkMap = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = 0, y = 0, di = 4;
		while(true) {
			if(x == n/2 && y == n/2) break;
			if(x+dir[di][0] >= 0 && x + dir[di][0] < n && y+dir[di][1] >= 0 && y + dir[di][1] < n && movingMap[x + dir[di][0]][y+dir[di][1]] == 0) {
				movingMap[x][y] = di;
				x += dir[di][0]; y += dir[di][1];
				checkMap[x][y] = (int) (di + Math.pow(-1, di + 1));
			} else {
				di = nextDir(di);
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				di = movingMap[i][j];
				checkMap[i + dir[di][0]][j + dir[di][1]] = (int) (movingMap[i][j] + Math.pow(-1, movingMap[i][j] + 1));
			}
		}
		movingMap[n/2][n/2 - 1] = 0;
		checkMap[0][0] = 0;
		
		// 마법 시전
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			// 마법 시전
			magic(d, s);
			
			// 이동
			map = move();
			
			// 연속된 구슬 폭발 + 이동
			while(crash() != 0) {
				map = move();
			}
			
			// 구슬 복제
			map = make();
		}
		
		System.out.println(boom[1] + 2 * boom[2] + 3 * boom[3]);
	}
	
	public static void print(int [][] map) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int nextDir(int di) {
		if(di == 4) di = 2;
		else if(di == 2) di = 3;
		else if(di == 3) di = 1;
		else if(di == 1) di = 4;
		
		return di;
	}
	
	public static void magic(int d, int s) {
		int x = n/2, y = n/2;
		for(int i = 0; i<s; i++) {
			x += dir[d][0]; y += dir[d][1];
			map[x][y] = 0;
		}
	}
	
	public static int[][] move() {
		int x = n/2, y = n/2 -1, nx = n/2, ny = n/2 - 1, di, ndi;
		int[][] newMap = new int[n][n];
		while(true) {
			if(x == 0 && y == 0) break;
			di = checkMap[x][y];
			ndi = checkMap[nx][ny];
			
			if(map[x][y] != 0) {
				newMap[nx][ny] = map[x][y];
				nx += dir[ndi][0];
				ny += dir[ndi][1];
			}
			x += dir[di][0];
			y += dir[di][1];
		}
		return newMap;
	}
	
	public static int con(int x, int y) {
		int ball = 0, di, num = map[x][y];
		while(map[x][y] == num) {
			ball++;
			di = checkMap[x][y];
			x += dir[di][0]; y += dir[di][1];
		}
		
		return ball;
	}
	
	public static int crash() {
		int ball = 0;
		
		int x = n/2, y = n/2 - 1, con, di;
		while(map[x][y] != 0) {
			if(x == 0 && y == 0) break;
			di = checkMap[x][y];
			con = con(x, y);
			if(con < 4) {
				x += dir[di][0]; y += dir[di][1];
				continue;
			}
			for(int i = 0; i<con; i++) {
				boom[map[x][y]]++;
				map[x][y] = 0;
				x += dir[di][0]; y += dir[di][1];
				di = checkMap[x][y];
			}
			ball += con;
		}
		
		return ball;
	}
	
	public static int[][] make() {
		int [][] newMap = new int[n][n];
		int x = n/2, y = n/2 - 1, nx = n/2, ny = n/2 - 1, di, idx = 0;
		while(map[x][y] != 0 && idx < n*n/2) {
			int ball = 0, direc, num = map[x][y];
			idx++;
			while(map[x][y] == num) {
				ball++;
				direc = checkMap[x][y];
				x += dir[direc][0]; y += dir[direc][1];
			}
			newMap[nx][ny] = ball;
			di = checkMap[nx][ny];
			nx += dir[di][0]; ny += dir[di][1];
			
			newMap[nx][ny] = num;
			di = checkMap[nx][ny];
			nx += dir[di][0]; ny += dir[di][1];
		}
		return newMap;
	}

}
