import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i<=N; i++) q.offer(i);
		int idx = 1;
		while(!q.isEmpty()) {
			if(idx == K) {
				sb.append(q.poll());
				if(!q.isEmpty()) sb.append(", ");
				idx = 1;
			}
			else {
				q.offer(q.poll());
				idx++;
			}
		}

		sb.append(">");
		System.out.println(sb);
	}
}
