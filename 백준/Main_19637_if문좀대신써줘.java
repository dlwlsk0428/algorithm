package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * if문 좀 대신 써줘
 * 시간초과 잡는게 힘들었던 문제...
 * 이분 탐색을 사용할 수 있었던 문제이다
 */
public class Main_19637_if문좀대신써줘 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String title[] = new String[N + 1];
		int fight[] = new int[N + 1];
		fight[0] = -1;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			title[i] = st.nextToken();
			fight[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<M; i++) {
			int x = Integer.parseInt(bf.readLine());
			sb.append(title[find(x, fight)]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int x, int fight[]) {
		int start = 0;
		int end = fight.length + 1;
		int mid = (start + end) /2;
		
		while(end - start > 1) {
			if(fight[mid] >= x) {
				end = mid;
			} else {
				start = mid;
			}
			mid = (start+end) /2;
		}
		
		if(fight[start] == fight[end]) return start;
		return end;
	}
}