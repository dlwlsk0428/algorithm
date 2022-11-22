package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	
	static int R, C;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(bf.readLine());
		int[] store = new int [N + 1];
		
		int dir, loc;
		for(int i = 0; i< N + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			dir = Integer.parseInt(st.nextToken());
			loc = Integer.parseInt(st.nextToken());
			
			store[i] = dist(dir, loc);
		}

		int answer = 0;
		for(int i = 0; i<N; i++) {
			int distance = Math.abs(store[N] - store[i]);
			answer += Math.min(distance, 2*R + 2*C - distance);
		}
		
		System.out.println(answer);
	}
	
	static int dist(int dir, int loc) {
		int distance = -1;
		if(dir == 1) distance = 2*R + C - loc;
		else if(dir == 2) distance = loc;
		else if(dir == 3) distance = 2*R + C + loc;
		else if(dir == 4) distance = R + C - loc;
		
		return distance;
	}
}