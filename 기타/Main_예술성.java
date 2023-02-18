import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_예술성 {

	public static int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static int n;
	public static List<int[]> first;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		int pic[][] = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j< n; j++) {
				pic[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = scored(pic);
		for(int i = 0; i<3; i++) {
			pic = rotate(pic);
			answer += scored(pic);
		}
				
		System.out.println(answer);
	}
	
	public static int[][] rotate(int[][] pic){
		int ropic[][] = new int[pic.length][pic[0].length];
		int h = pic.length/2;
		
		// 십자 회전
		for(int i = 0; i<n; i++) {
			ropic[n-i-1][n/2] = pic[n/2][i];
			ropic[n/2][i] = pic[i][n/2];
		}
		
		// 사각형 회전
		for(int i = 0; i<n/2; i++) {
			for(int j = 0; j<n/2; j++) {
				ropic[j][n/2 - i - 1] = pic[i][j];
				ropic[j + n/2 + 1][n/2 - i - 1] = pic[i+n/2+1][j];
				ropic[j][n - i - 1] = pic[i][j+n/2+1];
				ropic[j+n/2+1][n - i - 1] = pic[i+n/2+1][j+n/2+1];
			}
		}
		
		return ropic;
	}
	
	public static int[][] grouping(int[][] pic) {
		int group[][] = new int[n][n];
		Queue<int[]> queue = new LinkedList<>();
		first = new ArrayList<>();
		
		int idx = 1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(group[i][j] != 0) continue;
				int f[] = new int[] {i, j, pic[i][j], 1};
				group[i][j] = idx;
				queue.offer(f);
				while(!queue.isEmpty()) {
					int[] tmp = queue.poll();
					for(int d = 0; d<dir.length; d++) {
						int x = tmp[0] + dir[d][0], y = tmp[1] + dir[d][1];
						if(x < pic.length && x >= 0 && y < pic.length && y >= 0 && group[x][y] == 0 && pic[tmp[0]][tmp[1]] == pic[x][y]) {
							f[3]++;
							group[x][y] = idx;
							queue.offer(new int[] {x, y});
						}
					}
				}
				first.add(f);
				idx++;
			}
		}
		
		return group;
	}
	
	public static int scored(int [][] pic) {
		int score = 0;
		int group[][] = grouping(pic);
		int num = first.size();
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				for(int d = 0; d < dir.length; d++) {
					int x = i + dir[d][0], y = j + dir[d][1];
					if(x < pic.length && x >= 0 && y < pic.length && y >= 0 && group[x][y] != group[i][j]) {
						score += (first.get(group[i][j] - 1)[3] + first.get(group[x][y] - 1)[3]) * pic[x][y] * pic[i][j];
					}
				}
			}
		}
		
		return score/2;
	}

}
