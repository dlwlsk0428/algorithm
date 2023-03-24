import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	static int d[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int apt[][];
	static int answer[];
	static int N, index;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		apt = new int[N][N];
		answer = new int[N*N];

		for (int i = 0; i < N; i++) {
			String tmp = bf.readLine();
			for (int j = 0; j < N; j++) {
				apt[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (apt[i][j] == 0)
					continue;
				dfs(i, j);
				index++;
			}
		}
		
		int ans[] = Arrays.copyOfRange(answer, 0, index);
		Arrays.sort(ans);
		
		System.out.println(index);
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	static void dfs(int x, int y) {
		answer[index]++;
		apt[x][y] = 0;
		
		for (int i = 0; i < d.length; i++) {
			if (x + d[i][0] >= 0 && x + d[i][0] < N && y + d[i][1] < N && y + d[i][1] >= 0) {
				if (apt[x + d[i][0]][y + d[i][1]] == 1) {
					dfs(x + d[i][0], y + d[i][1]);
				}
			}
		}
	}

}
