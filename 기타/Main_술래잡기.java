import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_술래잡기 {
	
	public static class Runner{
		int x;
		int y;
		int d;
		boolean die;
		
		Runner(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		public void flip() {
			if(d == 0) d = 1;
			else if(d == 1) d = 0;
			else if(d == 2) d = 3;
			else if (d == 3) d = 2;
		}
	}

	public static int finder[];
	public static int d[][] = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}}; 
	// 상 우 하 좌 = 하 우 상 좌
	public static int dir[][] = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
	public static int n, m, h, k, move = 0, cnt = 0;
	public static boolean flip = true;
	public static int map[][];
	public static Runner runner[];
	public static boolean tree[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int answer = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		finder = new int[] {n/2 + 1, n/2 + 1, 0}; // x, y, dir
		map = new int[n+1][n+1];
		runner = new Runner[m]; 
		tree = new boolean[n+1][n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			runner[i] = new Runner(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i<h; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			tree[x][y] = true;
		}
		
		// 술래 잡기
		for(int i = 1; i<=k; i++) {
			answer += find(i) * i;
		}

		System.out.println(answer);
	}
	
	public static void run() {
		int x, y;
		for(int i = 0; i<m; i++) {
			if(runner[i].die) continue;
			if(Math.abs(finder[0] - runner[i].x) + Math.abs(finder[1] - runner[i].y) <= 3) {
				x = runner[i].x + d[runner[i].d][0];
				y = runner[i].y + d[runner[i].d][1];
				if(x <= 0 || x > n || y <= 0 || y > n) {
					runner[i].flip();
					x = runner[i].x + d[runner[i].d][0];
					y = runner[i].y + d[runner[i].d][1];
				}
				if(finder[0] == x && finder[1] == y) continue;
				runner[i].x = x;
				runner[i].y = y;
			}
		}
	}
	
	public static int find(int k) {
		int answer = 0;
		run();
		
		finder[0] += dir[finder[2]][0];
		finder[1] += dir[finder[2]][1];
		cnt++;
		
		// 방향 변경
		if(flip) {
			// 1, 1으로
			if(finder[0] == 1 && finder[1] == 1) {
				flip = false;
				finder[2] = 2;
				cnt = 0;
			}
			else if(cnt == move/2 + 1) {
				finder[2] = (finder[2] + 1) % 4;
				move++;
				cnt = 0;
			}
		} else {
			// 중심으로
			if(finder[0] == n/2 + 1 && finder[1] == n/2 + 1) {
				flip = true;
				finder[2] = 0;
				move = 0;
				cnt = 0;
			}
			else if(finder[0] == n && finder[1] == 1) {
				finder[2] = (finder[2] + 3) % 4;
				move--;
				cnt = 0;
			}
			else if(cnt == move/2 + 1) {
				finder[2] = (finder[2] + 3) % 4;
				move--;
				cnt = 0;
			}
		}
		
		for(int i = 0; i<m; i++) {
			if(runner[i].die || tree[runner[i].x][runner[i].y]) continue;
			for(int j = 0; j<3; j++) {
				if (runner[i].x == (finder[0] + dir[finder[2]][0] * j) && runner[i].y == (finder[1] + dir[finder[2]][1] * j)) {
					runner[i].die = true;
					answer++;
					break;
				}
			}
		}
		
		return answer;
	}

}
