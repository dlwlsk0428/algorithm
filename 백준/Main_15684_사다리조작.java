package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 사다리 조작
 * 전체 탐색이라 시간이 너무 많이 걸림...
 */
public class Main_15684_사다리조작 {

	static int answer = -1;
	static int d[][] = new int[][] {{0, -1}, {0, 1}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		boolean ladder[][] = new boolean[H][N];
		int ladderNum[] = new int [N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			ladderNum[b]++;
			ladder[a][b] = true;
		}
		
		for(int i = 0; i<=3; i++) {
			select(0, 0, 0, i, H, N, ladder, ladderNum);
			if (answer != -1) break;
		}
		
		System.out.println(answer);
	}
	
	static void select(int h, int w, int idx, int n, int H, int N, boolean ladder[][], int ladderNum[]) {
		if(answer != -1) return;
		if(idx == n) {
			int num = 0;
			for(int i = 0; i<N; i++) {
				if(ladderNum[i] % 2 != 0) num++;
				if(num > 3) return;
			}
			for(int i = 0; i<N; i++) {
				boolean visited[][] = new boolean[H][N];
				int nowx = H-1, nowy = i;
				
				while(nowx >= 0) {
					visited[nowx][nowy] = true;
					boolean flag = false;
					int x = nowx, y = nowy + 1;
					if(x >= 0 && x<H && y >= 0 && y < N && ladder[x][y - 1] && !visited[x][y]) {
						nowx = x; nowy = y;
						continue;
					}
					x = nowx; y = nowy - 1;
					if(x >= 0 && x<H && y >= 0 && y < N && ladder[x][y] && !visited[x][y]) {
						nowx = x; nowy = y;
						continue;
					}
					
					nowx--;
				}
				if(i != nowy) return;
			}
			answer = n;
			return;
		}
		
		for(int i = h; i<H; i++) {
			for(int j = i==h? w : 0; j<N-1; j++) {
				if(!ladder[i][j]) {
					if(j - 1 >= 0 && ladder[i][j -1]) continue;
					if(j + 1 < N && ladder[i][j + 1]) continue;
					ladder[i][j] = true;
					ladderNum[j]++;
					select(i, j, idx+1, n, H, N, ladder, ladderNum);
					ladder[i][j] = false;
					ladderNum[j]--;
				}
			}
		}
	}

}