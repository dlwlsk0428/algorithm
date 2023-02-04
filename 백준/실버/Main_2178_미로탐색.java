import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String map[] = new String[n];
		for(int i = 0; i<n; i++) {
			map[i] = bf.readLine();
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		boolean check[][] = new boolean[n][m];
		int dir[][] = new int[][] {{1, 0},{-1, 0},{0, 1},{0, -1}};
		queue.offer(new int[] {0, 0, 1});
		check[0][0] = true;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			if(now[0] == n-1 && now[1] == m-1) {
				System.out.println(now[2]);
				break;
			}
			
			for(int i = 0; i<dir.length; i++) {
				int x = dir[i][0] + now[0], y = dir[i][1] + now[1];
				if(x >= 0 && x < n && y >= 0 && y < m && !check[x][y] && map[x].charAt(y) == '1') {
					queue.offer(new int[] {x, y, now[2]+1});
					check[x][y] = true;
				}
			}
		}

	}

}
