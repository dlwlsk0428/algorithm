package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 파티
 * 길찾기 문제 - 다익스트라스 한번 더 보기!!!
 */
public class Main_1238_파티 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int distance[] = new int[N+1];
		boolean visited[] = new boolean [N+1];
		int distance2[] = new int[N+1];
		boolean visited2[] = new boolean [N+1];
		
		for(int i = 1; i<=N; i++) {
			distance[i] = -1;
			distance2[i] = -1;
		}
		distance[X] = 0;
		visited[X] = true;
		distance2[X] = 0;
		visited2[X] = true;
		
		PriorityQueue<Node>[] pq = new PriorityQueue[N+1];
		PriorityQueue<Node>[] pq2 = new PriorityQueue[N+1];
		for(int i = 1; i<=N; i++) {
			pq[i] = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
			pq2[i] = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq[u].add(new Node(v, w));
			pq2[v].add(new Node(u, w));
		}
		
		while(!pq[X].isEmpty()) {
			 Node curr = pq[X].poll();
			 int v = curr.v;
			 int w = curr.w;
			 
			 if(visited[v]) continue;
			 
			 visited[v] = true;
			 distance[v] = w;
			 while(!pq[v].isEmpty()){
				 Node tmp = pq[v].poll();
				 pq[X].add(new Node(tmp.v, tmp.w + w));
			 }
		 }
		
		while(!pq2[X].isEmpty()) {
			 Node curr = pq2[X].poll();
			 int v = curr.v;
			 int w = curr.w;
			 
			 if(visited2[v]) continue;
			 
			 visited2[v] = true;
			 distance2[v] = w;
			 while(!pq2[v].isEmpty()){
				 Node tmp = pq2[v].poll();
				 pq2[X].add(new Node(tmp.v, tmp.w + w));
			 }
		 }
		
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i<= N; i++) {
			answer = Math.max(distance[i] + distance2[i], answer);
		}
		
		System.out.println(answer);
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