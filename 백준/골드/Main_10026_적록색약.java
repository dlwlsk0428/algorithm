import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10026_적록색약 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		char grid[][] = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.charAt(j);
			}
		}

		int d[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean visited[][] = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();

		int normal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					normal++;
					visited[i][j] = true;
					queue.offer(new int[] { i, j });
					while (!queue.isEmpty()) {
						int tmp[] = queue.poll();
						for(int k = 0; k<d.length; k++) {
							int x = tmp[0] + d[k][0];
							int y = tmp[1] + d[k][1];
							if(x >= 0&& x<N && y >= 0 && y<N) {
								if(!visited[x][y] && grid[tmp[0]][tmp[1]] == grid[x][y]) {
									visited[x][y] = true;
									queue.offer(new int [] {x, y});
								}
							}
						}
					}
				}
			}
		}
		
		visited = new boolean[N][N];
		queue = new ArrayDeque<>();
		int rgb = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					rgb++;
					visited[i][j] = true;
					queue.offer(new int[] { i, j });
					while (!queue.isEmpty()) {
						int tmp[] = queue.poll();
						for(int k = 0; k<d.length; k++) {
							int x = tmp[0] + d[k][0];
							int y = tmp[1] + d[k][1];
							if(x >= 0&& x<N && y >= 0 && y<N && !visited[x][y]) {
								if(grid[tmp[0]][tmp[1]] == 'B' && grid[tmp[0]][tmp[1]] == grid[x][y]) {
									visited[x][y] = true;
									queue.offer(new int [] {x, y});
								}
								if((grid[tmp[0]][tmp[1]] == 'R' || grid[tmp[0]][tmp[1]] == 'G') && ('R' == grid[x][y] || 'G' == grid[x][y])) {
									visited[x][y] = true;
									queue.offer(new int [] {x, y});
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(normal + " " + rgb);
	}
}