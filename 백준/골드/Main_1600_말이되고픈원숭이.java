import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

	public static int answer = Integer.MAX_VALUE;
	public static int K;
	public static boolean visited[][][];
	public static Queue<int []> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int h[][] = new int[][] {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};
		int d[][] = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }};
//		int h[][] = new int[][] { { 2, 1 }, { 1, 2 } };
//		int d[][] = new int[][] { { 1, 0 }, { 0, 1 } };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		visited = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		queue.offer(new int[] {0, 0, 0, 0});
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int x = tmp[0], y = tmp[1], k = tmp[2], move = tmp[3];
			
			if(move > answer) return;
			if(x == map.length-1 && y == map[0].length - 1) {
				answer = Math.min(answer, move);
				break;
			}
			
			if (k < K) {
				for (int i = 0; i < h.length; i++) {
					if (x + h[i][0] >= 0 && x + h[i][0] < map.length && y + h[i][1] >= 0 && y + h[i][1] < map[0].length
							&& !visited[x + h[i][0]][y + h[i][1]][k+1] && map[x + h[i][0]][y + h[i][1]] == '0') {
//						System.out.println("h :" + (x + h[i][0]) + " " + (y + h[i][1]));
						visited[x + h[i][0]][y + h[i][1]][k+1] = true;
						queue.offer(new int[] {x + h[i][0], y + h[i][1], k+1, move+1});
					}
				}
			}

			for (int i = 0; i < d.length; i++) {
				if (x + d[i][0] >= 0 && x + d[i][0] < map.length && y + d[i][1] >= 0 && y + d[i][1] < map[0].length
						&& !visited[x + d[i][0]][y + d[i][1]][k] && map[x + d[i][0]][y + d[i][1]] == '0') {
//					System.out.println("d :" + (x + d[i][0]) + " " + (y + d[i][1]));
					visited[x + d[i][0]][y + d[i][1]][k] = true;
					queue.offer(new int[] {x + d[i][0], y + d[i][1], k, move+1});
				}
			}
		}


		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

}
