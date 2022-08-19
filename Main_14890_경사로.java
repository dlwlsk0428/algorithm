import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 경사로
 * 노가다 문제
 */
public class Main_14890_경사로 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int road = 0;
		for(int i = 0; i<N; i++) {
			boolean tmp[] = new boolean[N];
			boolean can = false;
			for(int j = 1; j<N; j++) {
				if(can) break;
				// 평평한 경우
				if(map[i][j-1] == map[i][j]) continue;
				int h = map[i][j-1];
				// 앞에 길이 더 높은 경우
				if(h - map[i][j] == 1) {
					boolean r = false;
					for(int k = j; k<j+L; k++) {
						if(k < N && map[i][j] == map[i][k] && !tmp[k]) continue;
						else {
							r = true;
							break;
						}
					}
					if(!r) {
						for(int k = j; k<j+L; k++) {
							tmp[k] = true;
						}
					} else can = true;
				}
				// 뒤에 길이 더 높은 경우
				else if(h - map[i][j] == -1) {
					boolean r = false;
					for(int k = j-L; k<j; k++) {
						if(k >= 0 && map[i][j-L] == map[i][k] && !tmp[k]) continue;
						else {
							r = true;
							break;
						}
					}
					if(!r) {
						for(int k = j-L; k<j; k++) {
							tmp[k] = true;
						}
					} else can = true;
				}
				else {
					can = true;
					break;
				}
			}
			if(!can) {
				road++;
			}
		}
		
		for(int i = 0; i<N; i++) {
			int h = map[0][i];
			boolean tmp[] = new boolean[N];
			boolean can = false;
			for(int j = 1; j<N; j++) {
				if(can) break;
				// 평평한 경우
				if(map[j-1][i] == map[j][i]) continue;
				h = map[j-1][i];
				// 앞에 길이 더 높은 경우
				if(h - map[j][i] == 1) {
					boolean r = false;
					for(int k = j; k<j+L; k++) {
						if(k < N && map[j][i] == map[k][i] && !tmp[k]) continue;
						else {
							r = true;
							break;
						}
					}
					if(!r) {
						for(int k = j; k<j+L; k++) {
							tmp[k] = true;
						}
					} else can = true;
				}
				// 뒤에 길이 더 높은 경우
				else if(h - map[j][i] == -1) {
					boolean r = false;
					for(int k = j-L; k<j; k++) {
						if(k >= 0 && map[j-L][i] == map[k][i] && !tmp[k]) continue;
						else {
							r = true;
							break;
						}
					}
					if(!r) {
						for(int k = j-L; k<j; k++) {
							tmp[k] = true;
						}
					} else can = true;
				}
				else {
					can = true;
					break;
				}
			}
			if(!can) {
				road++;
			}
		}
		
		System.out.println(road);
		
	}

}