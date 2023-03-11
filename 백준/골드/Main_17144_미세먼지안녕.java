import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	static int d[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int A[][] = new int[R][C];
		int top = -1, bottom = -1;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == -1 && top != -1)
					bottom = i;
			}
		}

		for (int i = 0; i < R; i++) {
			if (A[i][0] == -1) {
				top = i;
				bottom = i + 1;
				break;
			}
		}

		for (int t = 0; t < T; t++) {
			// 먼지 확산
			int temp[][] = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] <= 0)
						continue;
					int n = 0;
					for (int k = 0; k < d.length; k++) {
						if (i + d[k][0] >= 0 && i + d[k][0] < R && j + d[k][1] >= 0 && j + d[k][1] < C
								&& A[i + d[k][0]][j + d[k][1]] != -1) {
							n++;
							temp[i + d[k][0]][j + d[k][1]] += A[i][j] / 5;
						}
					}
					A[i][j] = A[i][j] - (A[i][j] / 5) * n;
				}
			}

			// 확산된 먼지 합산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					A[i][j] += temp[i][j];
				}
			}

			// 공기 청정기 - 위쪽
			int tmp = A[top][1], x = top, y = 1, dir = 0;
			int tx = x, ty = y;
			while (true) {
				if (dir == 0)
					ty++;
				else if (dir == 1)
					tx--;
				else if (dir == 2)
					ty--;
				else if (dir == 3)
					tx++;

				if (ty == C && tx == top) {
					dir++;
					ty--;
				} else if (ty == -1 && tx == 0) {
					dir++;
					ty = 0;
				} else if (tx == -1 && ty == C - 1) {
					dir++;
					tx = 0;
				} else if (tx == top && ty == 0) {
					A[top][1] = 0;
					break;
				} else {
					int swap = tmp;
					tmp = A[tx][ty];
					A[tx][ty] = swap;

					x = tx;
					y = ty;
				}
			}
			// 공기청정기 - 아래쪽
			tmp = A[bottom][1];
			x = bottom;
			y = 1;
			dir = 0;
			tx = x;
			ty = y;
			while (true) {
				if (dir == 0)
					ty++;
				else if (dir == 1)
					tx++;
				else if (dir == 2)
					ty--;
				else if (dir == 3)
					tx--;

				if (ty == C && tx == bottom) {
					dir++;
					ty--;
				} else if (ty == -1 && tx == R - 1) {
					dir++;
					ty = 0;
				} else if (tx == R && ty == C - 1) {
					dir++;
					tx--;
				} else if (tx == bottom && ty == 0) {
					A[bottom][1] = 0;
					break;
				} else {
					int swap = tmp;
					tmp = A[tx][ty];
					A[tx][ty] = swap;

					x = tx;
					y = ty;
				}
			}
		}
		// 출력
		int dust = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dust += A[i][j];
			}
		}
		System.out.println(dust + 2);
	}

}
