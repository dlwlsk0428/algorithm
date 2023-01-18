import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_1238_Contact
{
	static int answer;
	static Point graph[];
	static boolean visited[];
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			graph = new Point[N+1];
			
			for(int i = 1; i<=N; i++) {
				graph[i] = new Point(i);
			}
			
			st = new StringTokenizer(bf.readLine());
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int y =Integer.parseInt(st.nextToken());
				graph[x].list.add(y);
			}
			
			for(int i = 1; i<=N; i++) {
				graph[i].list.sort(Comparator.naturalOrder());
			}
			
			visited[start] = true;
			queue.offer(start);
			bfs();
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
	
	static void bfs() {
		if(queue.isEmpty()) {
			return;
		}
		else answer = 0;
		int N = queue.size();
		for(int i = 0; i<N; i++) {
			int n = queue.poll();
			answer = Math.max(answer, n);
			for(int j = 0; j<graph[n].list.size(); j++) {
				if(!visited[graph[n].list.get(j)]) {
					visited[graph[n].list.get(j)] = true;
					queue.offer(graph[n].list.get(j));
				}
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
