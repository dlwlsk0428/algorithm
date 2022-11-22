package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(bf.readLine());
		int A[];
		int B[];
		for(int i = 0; i<N; i++) {
			A = new int[5];
			B = new int[5];
			
			st = new StringTokenizer(bf.readLine());
			int na = Integer.parseInt(st.nextToken());
			for(int j = 0; j<na; j++) {
				int idx = Integer.parseInt(st.nextToken());
				A[idx]++;
			}
			
			st = new StringTokenizer(bf.readLine());
			int nb = Integer.parseInt(st.nextToken());
			for(int j = 0; j<nb; j++) {
				int idx = Integer.parseInt(st.nextToken());
				B[idx]++;
			}
			
			sb.append(win(A, B)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static String win(int A[], int B[]) {
		if(A[4] != B[4]) {
			return A[4] > B[4] ? "A": "B";
		}
		else if(A[3] != B[3]) {
			return A[3] > B[3] ? "A": "B";
		}
		else if(A[2] != B[2]) {
			return A[2] > B[2] ? "A": "B";
		}
		else if(A[1] != B[1]) {
			return A[1] > B[1] ? "A": "B";
		}
		
		return "D";
	}

}