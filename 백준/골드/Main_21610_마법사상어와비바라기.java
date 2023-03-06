

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {

	public static int map[][], dir[][];
	public static boolean cloud[][];
	public static int n, m;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		dir = new int[][] {{},{0, -1},{-1, -1},{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1}};
		cloud = new boolean[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		cloud[n-1][0] = cloud[n-1][1] = cloud[n-2][0] = cloud[n-2][1] = true;
		
		for(int time = 0; time <m; time++) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			// 이동
			cloud = move(d, s);
			// 구름 + 1
			rain();
			// 물복사 버그 시전
			magic();
			// 구름 - 2
			makeCloud();
//			print();
		}
		
		int water = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) water += map[i][j];
		}

		System.out.println(water);
	}
	
	public static void print() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println("=================");
	}
	
	public static boolean[][] findCloud() {
		boolean next[][] = new boolean[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] >=2 && !cloud[i][j]) next[i][j] = true;
			}
		}
		
		return next;
	}
	
	public static boolean[][] move(int d, int s) {
		boolean next[][] = new boolean[n][n];
		int x, y;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				if(cloud[i][j]) {
					// 수정 필요
					x = (i + dir[d][0] * s + n * 50) % n; y = (j + dir[d][1] * s + n * 50) % n; 
					next[x][y] = true;
				}
			}
		}
		
		return next;
	}
	
	public static void rain() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(cloud[i][j]) map[i][j]++;
			}
		}
	}
	
	public static void magic() {	
		int x, y;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(cloud[i][j]) {
					int water = 0;
					for(int d = 2; d<dir.length; d+=2) {
						x = i + dir[d][0]; y = j + dir[d][1];
						if(x >= 0 && x < map.length && y >= 0 && y < map.length && map[x][y] > 0) water++;
					}
					map[i][j] += water;
				}
			}
		}
		
		
	}
	
	public static void makeCloud() {
		cloud = findCloud();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(cloud[i][j]) map[i][j] -= 2;
			}
		}
	}
}
