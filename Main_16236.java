import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int d[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

		int N = Integer.parseInt(bf.readLine());
		int size = 2, eat = 0;
		int []bShark = null;
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bShark = new int [] {i, j};
					map[i][j] = 0;
				}
			}
		}

		int time = 0;
		
		while(true) {
			PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
					(o1, o2) -> 
					o1[2] != o2[2] ? (o1[2] > o2[2]? 1 : -1) : (o1[0] != o2[0] ? (o1[0] > o2[0]? 1 : -1) : (o1[1] > o2[1]? 1 : -1))
					);
			boolean [][] visit = new boolean[N][N];
			priorityQueue.add(new int [] {bShark[0], bShark[1], 0});
			visit[bShark[0]][bShark[1]] = true;
			boolean callMom = true;
			while(!priorityQueue.isEmpty()) {
				bShark = priorityQueue.poll();
				
				if(map[bShark[0]][bShark[1]] != 0 && map[bShark[0]][bShark[1]] < size) {
					map[bShark[0]][bShark[1]] = 0;
					eat++;
					time += bShark[2];
					callMom = false;
					break;
				}
				
				for(int i = 0; i<d.length; i++) {
					int x = bShark[0] + d[i][0];
					int y = bShark[1] + d[i][1];
					
					if(x >= 0 && x < N && y >= 0 && y < N && !visit[x][y] && map[x][y] <= size) {
						priorityQueue.add(new int [] {x, y, bShark[2] + 1});
						visit[x][y] = true;
					}
				}
			}
			
			if(callMom) break;
			
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(time);

	}
}