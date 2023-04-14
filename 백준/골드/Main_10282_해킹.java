import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_해킹 {
	
	public static class Node {
		int n;
		int s;
		
		public Node(int n, int s) {
			this.n = n;
			this.s = s;
		}
	}
	
	static int n, d, c, count;
	static ArrayList<Node>[] list;
	static boolean visited[];
	static int dist[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			for(int i = 0; i<n; i++) {
				list[i+1] = new ArrayList<>();
			}
			
			for(int i = 0; i<d; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list[b].add(new Node(a, s));
			}
			
			count = 0;
			dist = new int[n+1];
			visited = new boolean[n+1];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			
			dijkstra();
			int time = 0;
			for(int i = 1; i<=n; i++) {
				if(dist[i] != Integer.MAX_VALUE) time = Math.max(time, dist[i]);
			}
			
			System.out.println(count + " " + time);
		}

	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.s - o2.s);
		pq.offer(new Node(c, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.n]) {
				visited[now.n] = true;
				count++;
			} else continue;
			
			for(int i = 0; i<list[now.n].size(); i++) {
				Node next = list[now.n].get(i);
				if(dist[next.n] > dist[now.n] + next.s) {
					dist[next.n] = dist[now.n] + next.s;
					pq.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
	}

}
