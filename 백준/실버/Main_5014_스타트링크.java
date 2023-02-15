import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {

	public static int answer = Integer.MAX_VALUE;
	public static boolean check[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		check = new boolean[f+1];
		check[s] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {s, 0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == g) {
				answer = now[1];
				break;
			}
			
			if(now[0] + u <= g && !check[now[0] + u]) {
				check[now[0] + u] = true;
				queue.offer(new int[] {now[0] + u, now[1] + 1});
			}
			else if(now[0] - d > 0 && !check[now[0] - d]) {
				check[now[0] - d] = true;
				queue.offer(new int[] {now[0] - d, now[1] + 1});
			} else if(now[0] + u <= f && !check[now[0] + u]) {
				check[now[0] + u] = true;
				queue.offer(new int[] {now[0] + u, now[1] + 1});
			}
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);
	}
}
