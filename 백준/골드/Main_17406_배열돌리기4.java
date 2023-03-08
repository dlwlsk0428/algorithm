

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기 {

	public static int A[][], R[][], tmp[][], ro[];
	public static int n, m, k;
	public static boolean check[];
	public static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		A = new int[n+1][m+1];
		tmp = new int[n+1][m+1];
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		R = new int[k][3];
		ro = new int[k];
		check = new boolean[k];
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<3; j++) R[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(answer);
	}
	
	public static void rotate(int idx) {
		int r = R[idx][0], c = R[idx][1], s = R[idx][2], p = 2*s+1;
		int now[][] = new int[p][p];
		for(int i = 0; i< p; i++) {
			for(int j = 0; j < p; j++) {
				if(i - j <= 0 && i + j < p-1) now[i][j + 1] = tmp[r-s+i][c-s+j];
				else if(i - j < 0 && i + j >= p-1) now[i + 1][j] = tmp[r-s+i][c-s+j];
				else if(i - j >= 0 && i + j > p-1) now[i][j - 1] = tmp[r-s+i][c-s+j];
				else if(i - j > 0 && i + j <= p-1) now[i - 1][j] = tmp[r-s+i][c-s+j];
			}
		}
		
		for(int i = 0; i< p; i++) {
			for(int j = 0; j <p; j++) {
				if(i == s && j == s) continue;
				tmp[r-s+i][c-s+j] = now[i][j];
			}
		}
		
	}
	
	public static void result() {
		for(int i = 1; i<=n; i++) {
			int now = 0;
			for(int j = 1; j<=m; j++) now += tmp[i][j];
			answer = Math.min(answer, now);
		}
	}
	
	public static void dfs(int idx) {
		if(idx == k) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=m; j++) tmp[i][j] = A[i][j];
			}
			for(int i = 0; i<k; i++) rotate(ro[i]);
			result();
			return;
		}
		
		for(int i = 0; i<k; i++) {
			if(check[i]) continue;
			check[i] = true;
			ro[idx] = i;
			dfs(idx+1);
			check[i] = false;
		}
	}
}
