package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 여행가자
 */
public class Main_1976_여행가자 {

	static int city[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		boolean way[][] = new boolean [N+1][N+1];
		city = new int [N+1];
		for(int i = 1; i<=N; i++) {
			city[i] = i;
		}
		
		for(int i = 1; i<=N; i++) {
			String [] s = bf.readLine().split(" ");
			for(int j = i; j<N; j++) {
				if(s[j].equals("1")) {
					union(i, j+1);
				}
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = 0;
		for(int i = 0; i<M-1; i++) {
			end = Integer.parseInt(st.nextToken());
			if(find(start) != find(end)) {
				System.out.println("NO");
				return;
			}
			start = end;
		}
		
		System.out.println("YES");
	}
	
	static int find(int a) {
		if(a == city[a]) return a;
		
		return city[a] = find(city[a]);
	}
	
	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A == B) return;
		
		if(A>B) city[A] = B;
		else city[B] = A;
	}

}