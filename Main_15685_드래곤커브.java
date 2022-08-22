import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 드래곤 커브
 * 맨 밑에 힌트 그림땜에 더 헷갈렸네;;ㅋㅋㅋ
 */
public class Main_15685_드래곤커브 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int dir[][] = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		boolean grid[][] = new boolean[101][101];
		
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			grid[x][y] = true;
			x+=dir[d][0]; y+=dir[d][1];
			grid[x][y] = true;
			
			ArrayList<Integer> list = new ArrayList<>(); 
			list.add((d+1)%4);
			for(int i = 0; i<g; i++) {
				int size = list.size();
				for(int j = size - 1; j>= 0; j--) {
					d = (list.get(j) + 1) % 4;
					list.add(d);
					x += dir[list.get(j)][0];
					y += dir[list.get(j)][1];
					grid[x][y] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(grid[i][j]) {
					int x = i, y = j;
					boolean flag = false;
					for(int k = 0; k<3; k++) {
						x += dir[k][0]; y+= dir[k][1];
						if(x < 0 || x > 100 || y < 0 || y >100 || !grid[x][y]) {
							flag = true;
							break;
						}
					}
					if(flag) continue;
					else answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}