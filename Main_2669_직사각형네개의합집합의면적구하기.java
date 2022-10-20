import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 직사각형 네개의 합집합의 면적 구하기
 */
public class Main_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rec[][] = new int[4][4];
		
		int x = 0, y = 0;
		for(int i = 0; i<4; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<4; j++) {
				rec[i][j] = Integer.parseInt(st.nextToken());
			}
			x = Math.max(x, rec[i][2]);
			y = Math.max(y, rec[i][3]);
		}
		
		boolean area[][] = new boolean[x][y];
		for(int i = 0; i<4; i++) {
			for(int j = rec[i][0]; j<rec[i][2]; j++) {
				for(int k = rec[i][1]; k<rec[i][3]; k++) {
					area[j][k] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i<x; i++) {
			for(int j = 0; j<y; j++) {
				if(area[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
