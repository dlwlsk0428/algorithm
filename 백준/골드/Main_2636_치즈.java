import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		int d[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int num = 0, time = 0;
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0});
		boolean visited[][] = new boolean[N][M];
		
		while(true) {
			boolean check[][] = new boolean[N][M];	
			while(!queue.isEmpty()) {
				int [] tmp = queue.poll();
				int i = tmp[0], j = tmp[1];
				for(int k = 0; k<4; k++) {
					if(i + d[k][0] >= 0 && i + d[k][0] < N && j + d[k][1] >= 0 && j + d[k][1] < M) {
						if(visited[i + d[k][0]][j + d[k][1]]) continue;
						visited[i + d[k][0]][j + d[k][1]] = true;
						if(map[i + d[k][0]][j + d[k][1]] == '0') queue.offer(new int[] {i + d[k][0], j + d[k][1]});
						else check[i + d[k][0]][j + d[k][1]] = true;
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(check[i][j]) {
						queue.offer(new int[] {i, j});
						map[i][j] = '0';
					}
				}
			}
			
			if(!queue.isEmpty()) num = queue.size();
			else break;
			time++;
		}
		
		System.out.println(time);
		System.out.println(num);
	}

}
