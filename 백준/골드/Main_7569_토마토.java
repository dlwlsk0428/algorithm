import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int box[][][] = new int[h][n][m];
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<n; j++) {
				st = new StringTokenizer(bf.readLine());
				for(int k = 0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) queue.offer(new int[] {i, j, k, 0});
				}
			}
		}
		
		int dir[][] = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
		
		int day = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			day = Math.max(day, now[3]);
			for(int d =0; d<dir.length; d++) {
				int x = now[0] + dir[d][0], y = now[1] + dir[d][1], z = now[2] + dir[d][2];
				if(x >= 0 && x < h && y >= 0 && y < n && z >= 0 && z < m && box[x][y][z] == 0) {
					queue.offer(new int[] {x, y, z, now[3] + 1});
					box[x][y][z] = 1;
				}
			}
		}
		
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<m; k++) {
					if(box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(day);
	}

}
