package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 나무 재태크
 * 시간 미침;;; 채점 오지게 오래 걸린다...
 */
public class Main_16235_나무재태크 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int d[][] = new int[][] {{-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1},{1, -1},{1, 0}, {1, 1}};
		int map[][] = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				map[i][j] = 5;
			}
		}
		
		int winter[][] = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++) {
				winter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		ArrayList<int []> tree = new ArrayList<>();
		PriorityQueue<int []> trees = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			trees.offer(new int [] {x, y, z});
		}
		
		for(int year = 0; year < K; year++) {
			Queue<int[]> tmp = new ArrayDeque<>();
			Queue<int[]> die = new ArrayDeque<>();
			// 봄 + 여름
			while(!trees.isEmpty()) {
				int[] tree = trees.poll();
				if(tree[2] <= map[tree[0]][tree[1]]) {
					map[tree[0]][tree[1]] -= tree[2];
					tree[2]++;
					tmp.offer(tree);
				} else die.offer(tree);
			}
			
			// 여름
			while(!die.isEmpty()) {
				int[] tree = die.poll();
				map[tree[0]][tree[1]] += tree[2]/2;
			}
			
			// 가을
			while(!tmp.isEmpty()) {
				int[] tree = tmp.poll();
				trees.offer(tree);
				if(tree[2] % 5 == 0) {
					for(int i = 0; i<d.length; i++) {
						int x = tree[0] + d[i][0], y = tree[1] + d[i][1];
						if(x > 0 && x <= N && y > 0 && y <= N) {
							trees.offer(new int[] {x, y, 1});
						}
					}
				}
			}
			
			// 겨울
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					map[i][j] += winter[i][j];
				}
			}
		}
		
		System.out.println(trees.size());
		
	}

}