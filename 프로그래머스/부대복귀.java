import java.util.*;
class Solution {
    int[] dist;
	ArrayList<Integer> way[];
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
		way = new ArrayList[n+1];
		for(int i=1; i<way.length;i++) {
			 way[i] = new ArrayList<>();			
		 }
        for(int i = 0; i<roads.length; i++) {
        	way[roads[i][0]].add(roads[i][1]);
        	way[roads[i][1]].add(roads[i][0]);
        }

        dist = new int[n+1];
        Arrays.fill(dist, 100001);
        dijkstra(destination, way);
        
        for(int i = 0; i<sources.length; i++) answer[i] = dist[sources[i]] >= 100001 ? -1 : dist[sources[i]];
        
        return answer;
    }
    
    void dijkstra(int destination, ArrayList<Integer> way[]) {
    	PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
    	boolean check[] = new boolean[dist.length];
    	q.offer(new int[] {destination, 0});
    	dist[destination] = 0;
    	while(!q.isEmpty()) {
    		int now[] = q.poll();
    		if(check[now[0]]) continue;
    		check[now[0]] = true;
    		if(dist[now[0]] < now[1]) continue;
    		for(int i = 0; i < way[now[0]].size(); i++) {
    			int next = way[now[0]].get(i);
    			if(dist[next] > now[1] + 1) {
    				dist[next] = now[1] + 1;
    				q.offer(new int[] {next, dist[next]});
    			}
    		}
    	}
    }
}
