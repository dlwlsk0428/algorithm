import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/*
 * 수열
 * 아나 다 하고 answer = add 를 중간에 안해서 ... 하
 */
public class Main_2559_수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<Integer>();
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int answer = 0, add = 0, temp;
		
		for(int i = 0; i<K; i++) {
			temp = sc.nextInt();
			queue.offer(temp);
			add += temp;
		}
		answer = add;
		for(int i = K; i<N; i++) {
			add -= queue.poll();
			temp = sc.nextInt();
			queue.offer(temp);
			add += temp;
			answer = Math.max(answer, add);
		}
		
		System.out.println(answer);
	}

}
