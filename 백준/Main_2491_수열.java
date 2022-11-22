package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 수열
 * > 마지막에 비교 안해서 틀렸었음... 이런거 주의!
 */
public class Main_2491_수열 {

	static int N, index;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static int ans1 = 1, ans2 = 1, answer = 1;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		int a1 = queue.poll(), a2;
		while (!queue.isEmpty()) {
			a2 = queue.poll();
			if (a1 < a2) {
				ans2 = 1;
				ans1++;
			} else if (a1 > a2) {
				ans1 = 1;
				ans2++;
			} else {
				ans1++;
				ans2++;
			}
			answer = Math.max(ans1, answer);
			answer = Math.max(ans2, answer);
			a1 = a2;
		}
		System.out.println(answer);
	}
}
