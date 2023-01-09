import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	static boolean selected[];
	static char map[][];
	static ArrayList<CCTV> list = new ArrayList<>();
	static int N, M, answer = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int room = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M; j++) {
				 map[i][j] = st.nextToken().charAt(0);
				 if(map[i][j] == '0'){ room++; continue; }
				 if(map[i][j] != '6') {
					 list.add(new CCTV(map[i][j], i, j));
				 }
			}
		}
		selected = new boolean[list.size()];
		
		watch(0);
		
		System.out.println(room - answer);
	}
	
	static void monitoring(int idx, char map[][]) {
		int d[][] = list.get(idx).deltas;
		for(int i = 0; i<d.length; i++) {
			int x = list.get(idx).x, y = list.get(idx).y;
			while(true) {
				if(list.get(idx).dir == 0) {
					x += d[i][0];
					y += d[i][1];
				}
				else if(list.get(idx).dir == 1) {
					x -= d[i][1];
					y += d[i][0];
				}
				else if(list.get(idx).dir == 2) {
					x -= d[i][0];
					y -= d[i][1];
				}
				else if(list.get(idx).dir == 3) {
					x += d[i][1];
					y -= d[i][0];
				}
				
				if(x<0 || x>= N || y <0 || y >= M || map[x][y] == '6') break;
				else if(map[x][y] == '0') map[x][y] = '#';
			}
		}
	}
	
	static void watch(int n) {
		if(n == list.size()) {
			int sum = 0;
			char temp[][] = new char [N][M];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			for(int idx = 0; idx<list.size(); idx++) {
				monitoring(idx, temp);
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(temp[i][j]=='#') sum++;
				}
			}
			
			answer = Math.max(answer, sum);
			return;
		}
		for(int j = 0; j < list.get(n).time; j++) {
			list.get(n).dir = j;
			watch(n+1);
		}
	}
	
	static class CCTV {
		char type;
		int dir;
		int deltas[][];
		int time;
		int x;
		int y;
		
		CCTV(char type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
			if(type == '1') {
				this.deltas = new int[][] {{0, -1}};
				this.time = 4;
			}
			else if(type == '2') {
				this.deltas = new int[][] {{0, -1}, {0, 1}};
				this.time = 2;
			}
			else if(type == '3') {
				this.deltas = new int[][] {{0, 1}, {-1, 0}};
				this.time = 4;
			}
			else if(type == '4') {
				this.deltas = new int[][] {{0, -1}, {0, 1}, {-1, 0}};
				this.time = 4;
			}
			else if(type == '5') {
				this.deltas = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
				this.time = 1;
			}
		}
	}

}