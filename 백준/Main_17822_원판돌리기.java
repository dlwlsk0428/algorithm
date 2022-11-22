package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int disk[][] = new int[N+1][M];
		boolean deleted[][];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M; j++) {
				int x = Integer.parseInt(st.nextToken());
				disk[i][j] = x;
			}
		}
		
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()); 
			int d = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken()); 
			
			// 회전
			for(int j = 1; j<=N; j++) {
				if(j%x == 0) {
					int tmp[] = new int[M];
					for(int p = 0; p <M; p++) {
						if(d == 0) tmp[(p + M + k) % M] = disk[j][p];
						else tmp[(p + M - k) % M] = disk[j][p];
					}
					for(int p = 0; p<M; p++) {
						disk[j][p] = tmp[p];
					}
				}
			}
			
			// 인접 확인
			int n = 0;
			deleted = new boolean[N+1][M];
			for(int j = 1; j<=N; j++) {
				for(int p = 0; p<M; p++) {
					if(disk[j][p] <= 0) continue;
					// 양 옆 확인
					if(disk[j][(p + 1) % M] == disk[j][p]) {
						deleted[j][(p + 1) % M] = true;
						deleted[j][p] = true;
						n++;
					}
					if(disk[j][(p - 1 + M) % M] == disk[j][p]) {
						deleted[j][(p - 1 + M) % M] = true;
						deleted[j][p] = true;
						n++;
					}
					// 원판 확인
					if(j-1 > 0 && disk[j-1][p] == disk[j][p]) {
						deleted[j-1][p] = true;
						deleted[j][p] = true;
						n++;
					}
					if(j+1 <= N && disk[j+1][p] == disk[j][p]) {
						deleted[j+1][p] = true;
						deleted[j][p] = true;
						n++;
					}
				}
			}
			
			if(n > 0) {
				for(int j = 1; j<=N; j++) {
					for(int p = 0; p<M; p++) {
						if(deleted[j][p]) disk[j][p] = -1;
					}
				}
			}
			else {
				int add = 0, num = 0;
				for(int j = 1; j<=N; j++) {
					for(int p = 0; p<M; p++) {
						if(disk[j][p] > 0) {
							add+=disk[j][p];
							num++;
						}
					}
				}
				
				if(num == 0) continue;
				for(int j = 1; j<=N; j++) {
					for(int p = 0; p<M; p++) {
						if(disk[j][p] > 0) {
							if(disk[j][p] > (1.0) * add / num) disk[j][p]--;
							else if(disk[j][p] < (1.0) * add / num) disk[j][p]++;
						}
					}
				}
			}
		}
		
		int add = 0;
		for(int j = 1; j<=N; j++) {
			for(int p = 0; p<M; p++) {
				if(disk[j][p] > 0) {
					add+=disk[j][p];
				}
			}
		}
		System.out.println(add);
	}

}