import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {

	static Point graph[];
	static boolean visited[];
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		graph = new Point[N+ 1];
		for(int i = 0; i<=N; i++) {
			graph[i] = new Point(i);
		}
				
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			graph[x].list.add(y);
			graph[y].list.add(x);
		}
		
		for(int i = 1; i<=N; i++) {
			graph[i].list.sort(Comparator.naturalOrder());
		}
		
		visited[V] = true;
		dfs(V);
		System.out.println();
		visited[V] = false;
		queue.offer(V);
		bfs();
		
	}
	
	static void dfs(int n) {
		System.out.print(n + " ");
		for(int i = 0; i<graph[n].list.size(); i++) {
			if(!visited[graph[n].list.get(i)]) {
				visited[graph[n].list.get(i)] = true;
				dfs(graph[n].list.get(i));
			}
		}
	}
	
	static void bfs() {
		if(queue.isEmpty()) {
			return;
		}
		int n = queue.poll();
		System.out.print(n + " ");
		for(int i = 0; i<graph[n].list.size(); i++) {
			if(visited[graph[n].list.get(i)]) {
				visited[graph[n].list.get(i)] = false;
				queue.offer(graph[n].list.get(i));
			}
		}
		bfs();
	}
	
	static class Point {
		int v;
		ArrayList<Integer> list = new ArrayList<>();
		
		Point(int v){
			this.v = v;
		}
	}

}