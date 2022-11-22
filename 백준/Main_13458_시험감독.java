package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시험 감독
 * 최악의 경우 1,000,000 * 1,000,000 으로 int 범위를 넘어선다
 * int 범위 -> -+2,147,483,647
 */
public class Main_13458_시험감독 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int A[] = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		double answer = 0;
		for(int i = 0; i<N; i++) {
			A[i] = A[i] - B < 0 ? 0 : A[i] - B;
			answer++;
			
			answer += Math.ceil((1.0) * A[i]/C);
		}
		
		System.out.printf("%.0f", answer);
	}

}