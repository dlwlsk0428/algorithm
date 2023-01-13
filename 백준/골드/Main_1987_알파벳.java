import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	
	static boolean visited[];
	static char board[][];
	static int R, C, answer;
	static int d[][] = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[27];
		
		for(int i = 0; i<R; i++) {
			String s = bf.readLine();
			for(int j = 0; j<C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		visit(0, 0, 1);
		
		System.out.println(answer);
	}

	static void visit(int x, int y, int sum) {
		visited[board[x][y] - 'A'] = true;
		for(int i = 0; i<d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(!visited[board[nx][ny] - 'A']) {
				visit(nx, ny, sum + 1);
				visited[board[nx][ny] - 'A'] = false;
			}
		}
		answer = Math.max(answer, sum);
	}
}