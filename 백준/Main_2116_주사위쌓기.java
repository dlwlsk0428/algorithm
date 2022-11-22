package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 주사위 쌓기
 */
public class Main_2116_주사위쌓기 {

	static int [][] dices;
	static int N, answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		dices = new int[N][6];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<= 6; i++) {
			stack(i, 0, 0);
		}
		
		System.out.println(answer);
		
	}
	
	static void stack(int frontVal, int n, int add) {
		if(n == N) {
			answer = Math.max(answer, add);
			return;
		}
		
		int backId, frontId = -1;
		for(backId = 0; backId<6; backId++) {
			if(dices[n][backId] == frontVal) {
				if(backId == 0) frontId = 5;
				else if(backId == 1) frontId = 3;
				else if(backId == 2) frontId = 4;
				else if(backId == 3) frontId = 1;
				else if(backId == 4) frontId = 2;
				else if(backId == 5) frontId = 0;			
				break;
			}
		}
		
		int max = -1;
		for(int k = 0; k<6; k++) {
			if(k == frontId || k == backId) continue;
			if(max < dices[n][k]) max = dices[n][k];
		}
		
		System.out.println(n +": " +dices[n][frontId] + " "+ add + " "  + max + " "+ answer);
		stack(dices[n][frontId], n+1, add + max);
	}

}
