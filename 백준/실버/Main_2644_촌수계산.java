import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> list[] = new ArrayList[n+1];
		for(int i= 1; i<=n; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		boolean check[] = new boolean[n+1];
		int chon = -1;
		queue.add(new int[] {a, 0});
		check[a] = true;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			if(now[0] == b) {
				chon = now[1];
				break;
			}
			for(int i : list[now[0]]) {
				if(!check[i]) {
					queue.add(new int[] {i, now[1]+1});
					check[i] = true;
				}
			}
		}
		
		System.out.println(check[b] ? chon : -1);

	}

}
