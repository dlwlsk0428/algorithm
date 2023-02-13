import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		ArrayList<Integer> net[] = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			net[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			net[a].add(b);
			net[b].add(a);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean com[] = new boolean[n];
		int num = 0;
		
		queue.offer(0);
		com[0] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			num++;
			for(int i : net[now]) {
				if(!com[i]) {
					com[i] = true;
					queue.add(i);
				}
			}
		}
		
		System.out.println(num - 1);
	}

}
