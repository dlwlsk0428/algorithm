import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_카드2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i<=n; i++) queue.offer(i);
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		System.out.println(queue.poll());
	}
}
