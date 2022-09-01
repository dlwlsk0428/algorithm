import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 최소 힙 - 우선순위큐를 사용
 */
public class Main_1927_최소힙 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for(int i = 0; i<N; i++) {
			int n = Integer.parseInt(bf.readLine());
			if(n == 0) {
				sb.append(minHeap.isEmpty() ? "0\n":minHeap.poll()+"\n");
			}
			else {
				minHeap.offer(n);
			}
		}
		
		System.out.println(sb);
	}

}