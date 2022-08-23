import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 스타트 택시
 * 첨엔 dfs 로 했다가 시간초과 남;; 
 * 글구 문제 제대로 안읽어서 승객을 잘못 골랐었다...
 * 계속 틀리는데 개빡침; 
 * minx miny 값 할당을 안해줌ㅋㅋㅋ 고마워요 주희님
 */
public class Main_19238_스타트택시 {
	static int passenger, min, minx, miny;
	static int d[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1},{0, 1}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		char map[][] = new char[N][N];
		int pass[][] = new int[M][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			map[x1][y1] = (char)( i + '2' );
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			pass[i] = new int[] {x1, y1, x2, y2};
		}
		
		for(int i = 0; i<M; i++) {
			passenger = Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			minx = Integer.MAX_VALUE;
			miny = Integer.MAX_VALUE;
			find(x, y, map);
			if(passenger == Integer.MAX_VALUE) {
				fuel = -1;
				break;
			}
			
			fuel -= min;
			if(fuel < 0) break;
			
			int tomin = findWay(pass[passenger][0], pass[passenger][1], pass[passenger][2], pass[passenger][3], map);
			if(tomin == -1) {
				fuel = -1;
				break;
			}
			
//			System.out.println("taxi ~ " + (passenger + 1) + ": " + min);
//			System.out.printf("%d %d -> %d %d : %d\n",x, y, pass[passenger][2], pass[passenger][3],tomin);
			fuel -= tomin;
			if(fuel < 0) break;
			
			map[pass[passenger][0]][pass[passenger][1]] = '0';
			x = pass[passenger][2];
			y = pass[passenger][3];
			
			fuel += tomin * 2;
		}
		
		System.out.println(fuel < 0 ? -1: fuel);
	}
	
	static void find(int x, int y, char map[][]) {
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 0});
		boolean visited[][] = new boolean[map.length][map.length];
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			
			if(tmp[2] > min) continue;
			if(map[tmp[0]][tmp[1]] > '1') {
				if(tmp[2] == min) {
					if(minx > tmp[0]) {
						passenger = map[tmp[0]][tmp[1]] - '2';
						minx = tmp[0];
						miny = tmp[1];
					}
					else if(minx == tmp[0] && miny>tmp[1]) {
						passenger = map[tmp[0]][tmp[1]] - '2';
						minx = tmp[0];
						miny = tmp[1];
					}
				} 
				else if(tmp[2] < min) {
					minx = tmp[0];
					miny = tmp[1];
					min = tmp[2];
					passenger = map[tmp[0]][tmp[1]] - '2';
				}
			}
			
			for(int i = 0; i<d.length; i++) {
				if(tmp[0] + d[i][0] < 0 || tmp[0] + d[i][0]>= map.length || tmp[1] + d[i][1] < 0 || tmp[1] + d[i][1] >= map.length) continue;
				
				if(map[tmp[0] + d[i][0]][tmp[1] + d[i][1]] == '1' || visited[tmp[0] + d[i][0]][tmp[1] + d[i][1]]) continue;
				
				visited[tmp[0] + d[i][0]][tmp[1] + d[i][1]] = true;
				queue.offer(new int[] {tmp[0] + d[i][0], tmp[1] + d[i][1], tmp[2] + 1});
			}
		}
	}
	
	static int findWay(int x, int y, int fx, int fy, char map[][]) {
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 0});
		boolean visited[][] = new boolean[map.length][map.length];
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			if(tmp[0] == fx && tmp[1] == fy) {
				return tmp[2];
			}
			
			for(int i = 0; i<d.length; i++) {
				if(tmp[0] + d[i][0] < 0 || tmp[0] + d[i][0]>= map.length || tmp[1] + d[i][1] < 0 || tmp[1] + d[i][1] >= map.length) continue;
				if(map[tmp[0] + d[i][0]][tmp[1] + d[i][1]] == '1' || visited[tmp[0] + d[i][0]][tmp[1] + d[i][1]]) continue;
				
				visited[tmp[0] + d[i][0]][tmp[1] + d[i][1]] = true;
				queue.offer(new int[] {tmp[0] + d[i][0], tmp[1] + d[i][1], tmp[2] + 1});
			}
		}
		
		return -1;
	}

}