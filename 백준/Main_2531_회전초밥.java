package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 회전 초밥
 */
public class Main_2531_회전초밥 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int chobab[] = new int [N];
		int eat[] = new int [d + 1];
		for(int i = 0; i<N; i++) {
			chobab[i] = Integer.parseInt(bf.readLine());
		}
		
		int type = 0, answer = 0;
		for(int i = 0; i<k; i++) {
			if(eat[chobab[i]] == 0) type++;
			eat[chobab[i]]++;
		}
		answer = eat[c] == 0 ? type+1 : type;
		
		for(int start = 0, end = k; start<N; start++, end++) {
			if(answer == d+1) break;
			if(end == N) end = 0;
			
			if(--eat[chobab[start]] == 0) type--;
			if(eat[chobab[end]]++ == 0) type++;
			
			answer = Math.max(eat[c] == 0 ? type+1 : type, answer);
		}
		
		System.out.println(answer);
	}
}