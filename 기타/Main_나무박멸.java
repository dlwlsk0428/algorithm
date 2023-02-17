import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_나무박멸 {

	public static int dir[][] = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static int dir2[][] = new int[][] {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
	public static int map[][], tree[][];
	public static int n, m, k, c, kill = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int answer = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		tree = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<m; i++) {
			// 성장
			grow();
			// 번식
			tree = child();
			// 박멸
			kill();
			
			answer += kill;
		}

		System.out.println(answer);
		
	}
	
	public static boolean inRange(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < n) return true;
		return false;
	}
	
	public static void grow() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				if(tree[i][j] <= 0) continue;
				int num = 0;
				for(int d = 0; d<dir.length; d++) {
					if(inRange(i + dir[d][0], j + dir[d][1]) && tree[i + dir[d][0]][j + dir[d][1]] > 0) num++;
				}
				tree[i][j] += num;
			}
		}
	}
	
	public static int[][] child() {
		int tmp[][] = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				tmp[i][j] = tree[i][j];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				if(tree[i][j] <= 0) continue;
				int num = 0;
				for(int d = 0; d<dir.length; d++) {
					int x = i + dir[d][0], y= j + dir[d][1];
					if(inRange(x, y) && tree[x][y] == 0 && map[x][y] == 0) num++;
				}
				if(num == 0) continue;
				for(int d = 0; d<dir.length; d++) {
					int x = i + dir[d][0], y= j + dir[d][1];
					if(inRange(x, y) && tree[x][y] == 0 && map[x][y] == 0) {
						tmp[x][y] += (tree[i][j] / num);
					}
				}
			}
		}
		
		return tmp;
	}
	
	public static int[] find() {
		int place[] = new int[2];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(tree[i][j] <= 0) continue;
				int die = tree[i][j];
				for(int d = 0; d<dir2.length; d++) {
					for(int p = 1; p<=k; p++) {
						int x = i + dir2[d][0] * p, y= j + dir2[d][1] * p;
						if(!inRange(x, y) || tree[x][y] <= 0) break;
						die += tree[x][y];
					}
				}
				
				if(kill < die) {
					kill = die;
					place = new int[] {i, j};
				}
			}
		}
		
		return place;
	}
	
	public static void kill() {
		kill = 0;
		int place[] = find();
//		System.out.println(place[0] + " " + place[1]);
		tree[place[0]][place[1]] = 0;
		map[place[0]][place[1]] = c + 1;
		for(int d = 0; d<dir2.length; d++) {
			for(int p = 1; p<=k; p++) {
				int x = place[0] + dir2[d][0] * p, y= place[1] + dir2[d][1] * p;
				if(!inRange(x, y)) break;
				map[x][y] = c + 1;
				if(tree[x][y] <= 0) break;
				tree[x][y] = 0;
			}
		}
		
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<n; j++) {
//				System.out.print(map[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println("=======================");
		
		nextYear();
	}
	
	public static void nextYear() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(map[i][j] == 0) continue;
				map[i][j]--;
			}
		}
	}

}
