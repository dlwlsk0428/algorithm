import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 색종이 - 가려지지 않은 면적 구하기
 */
public class Main_10163_색종이 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int area[][] = new int[1002][1002];
		int paper[] = new int[N+1];
		
		for(int n = 1; n<=N; n++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int i = x; i <x + r ; i++) {
				for(int j = y; j<y + c; j++) {
					area[i][j] = n;
				}
			}
		}
		
		for(int i = 0; i <1001 ; i++) {
			for(int j = 0; j<1001; j++) {
				paper[area[i][j]]++;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.println(paper[i]);
		}		
	}
	

}