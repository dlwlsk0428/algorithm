import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 마법사 상어와 파이어볼
 */
public class Main_20056_마법사상어와파이어볼 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int dir[][] = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
				{ -1, -1 } };
		Queue<int[]>[][] map = new ArrayDeque[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayDeque<int[]>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[r][c].offer(new int[] { m, s, d });
		}

		// 이동
		for (int move = 0; move < K; move++) {
			Queue<int []> tmpqueue = new ArrayDeque<>();
			// 1번 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].isEmpty())
						continue;
					while(!map[i][j].isEmpty()) {
						int tmp[] = map[i][j].poll();
						int x = (i + tmp[1] * dir[tmp[2]][0]) % N;
						int y = (j + tmp[1] * dir[tmp[2]][1]) % N;
						
						while(x < 0) x += N;
						while(y < 0) y += N;
						
						tmpqueue.offer(new int [] {x, y, tmp[0], tmp[1], tmp[2]});
					}
				}
			}
			
			while(!tmpqueue.isEmpty()) {
				int tmp[] = tmpqueue.poll();
				map[tmp[0]][tmp[1]].offer(new int[] {tmp[2], tmp[3], tmp[4]});
			}
			
			// 2번 합치기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].isEmpty() || map[i][j].size() == 1)
						continue;
					int weight = 0, speed = 0, size = map[i][j].size();
					int dirc = map[i][j].peek()[2] % 2;
					boolean flag = false;
					while(!map[i][j].isEmpty()) {
						int tmp[] = map[i][j].poll();
						weight += tmp[0];
						speed += tmp[1];
						if(tmp[2] % 2 != dirc) flag = true;
					}
					if(weight/5 == 0) continue;
					if(flag) dirc = 1;
					else dirc = 0;
					
					for(int k = dirc; k<8; k+=2) {
						map[i][j].add(new int[] {weight/5, speed/size, k});
					}
					
				}
			}
			
		}

		// 남은 파이어볼 무게
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].isEmpty())
					continue;
				while(!map[i][j].isEmpty()) {
					answer += map[i][j].poll()[0];
				}
			}
		}

		System.out.println(answer);
	}

}