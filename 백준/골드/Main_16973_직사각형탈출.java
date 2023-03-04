

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {

	public static int map[][], dir[][];
	public static boolean visited[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int fr = Integer.parseInt(st.nextToken()) - 1;
		int fc = Integer.parseInt(st.nextToken()) - 1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			if(now[0] == fr && now[1] == fc) {
				System.out.println(now[2]);
				return;
			}
			
			for(int d = 0; d<dir.length; d++) {
				int x = now[0] + dir[d][0], y = now[1] + dir[d][1];
				if(find(x, y) && find(x + h - 1, y + w -1) && !visited[x][y] && check(h, w, x, y)) {
					visited[x][y] = true;
//					System.out.println(x + " " + y + " -> " + (now[2] + 1));
					queue.offer(new int[] {x, y, now[2]+1});
				}
			}
		}

		System.out.println(-1);
	}
	
	public static boolean find(int x, int y) {
		if(x >= 0 && x <map.length && y >= 0 && y < map[0].length) return true;
		
		return false;
	}
	
	public static boolean check(int h, int w, int r, int c) {
		for(int i = r; i<r+h; i++) {
			for(int j = c; j<c+w; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
}
