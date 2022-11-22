package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 방 배정
 */
public class Main_13300_방배정 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int room[][] = new int[2][7];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			room[S][Y]++;
		}
		
		int num = 0;
		for(int i = 0; i<2; i++) {
			for(int j = 1; j<=6; j++) {
				if(room[i][j] != 0) {
					num += room[i][j] / K; 
					if(room[i][j] % K != 0) num++;
				}
			}
		}
		
		System.out.println(num);
	}

}