import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(bf.readLine());
		int distance[] = new int[V+1];
		boolean visited[] = new boolean [V+1];
		
		for(int i = 1; i<=V; i++) {
			distance[i] = -1;
		}
		distance[K] = 0;
		visited[K] = true;
		
		PriorityQueue<Node>[] pq = new PriorityQueue[V+1];
		for(int i = 1; i<=V; i++) {
			pq[i] = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		}
	
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq[u].add(new Node(v, w));
		}
		
		 while(!pq[K].isEmpty()) {
			 Node curr = pq[K].poll();
			 int v = curr.v;
			 int w = curr.w;
			 
			 if(visited[v]) continue;
			 
			 visited[v] = true;
			 distance[v] = w;
			 while(!pq[v].isEmpty()){
				 Node tmp = pq[v].poll();
				 pq[K].add(new Node(tmp.v, tmp.w + w));
			 }
		 }
		 
		 for(int i = 1; i<= V; i++) {
			 System.out.println(distance[i] == -1 ? "INF" : distance[i]);
		 }

	}
	
	static class Node {
		int v;
		int w;
		
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
}
