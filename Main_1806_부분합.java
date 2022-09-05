import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 부분합 - 큐로
 */
public class Main_1806_부분합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int num[] = new int[N];
		
		st= new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> queue = new ArrayDeque<>();
		
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			queue.offer(num[i]);
			sum += num[i];
			
			if(sum >= S) {
				while(sum >= S) {
					answer = Math.min(answer, queue.size());
					sum -= queue.poll();
				}
			} 
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0: answer);
	}
}