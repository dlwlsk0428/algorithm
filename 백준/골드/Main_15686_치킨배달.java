import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int answer = Integer.MAX_VALUE;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][N];
		
		
		for(int i = 0; i<N; i++) {
			 st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j] == 1) home.add(new int[] {i, j});
				else if(map[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		
		boolean selected[] = new boolean[chicken.size()];
		
		dfs(0, 0, M, selected);
		
		System.out.println(answer);
		
	}
	
	static int chicken_range(int []home, int []chicken) {
		return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
	}

	static void dfs(int idx, int n, int M, boolean []selected) {
		if(n == M) {
			int tmp = 0;
			for(int i = 0; i< home.size(); i++) {
				int chicken_dist = Integer.MAX_VALUE;
				for(int j = 0; j<chicken.size(); j++) {
					if(selected[j]) {
						chicken_dist = Math.min(chicken_dist, chicken_range(home.get(i), chicken.get(j)));
					}
				}
				tmp += chicken_dist;
			}
			answer = Math.min(answer, tmp);
		}
		if(idx == chicken.size()) return;
		
		selected[idx] = true;
		dfs(idx+1, n+1, M, selected);
		selected[idx] = false;
		dfs(idx+1, n, M, selected);
	}
}
