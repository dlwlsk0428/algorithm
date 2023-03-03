import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int [][]image = new int[N][N];
		
		for(int i = 0; i< N; i++) {
			String s = bf.readLine();
			for(int j = 0; j<N; j++) {
				image[i][j] = s.charAt(j) - '0';
			}
		}
		
		quardTree(N, 0, 0, image);
		
		System.out.println(sb);
	}
	
	static void quardTree(int N, int x, int y, int[][] image) {
		
		if(canZip(N, x, y, image)) {
			sb.append(image[x][y]);
			return;
		}
		
		N /= 2;
		
		sb.append("(");	
		// 1사분면
		quardTree(N, x, y, image);
		// 2사분면
		quardTree(N, x, y+N, image);
		// 3사분면
		quardTree(N, x+N, y, image);
		// 4사분면
		quardTree(N, x+N, y+N, image);
		sb.append(")");
	}
	
	static boolean canZip(int N, int x, int y, int [][] image) {
		for(int i = x; i<x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(image[i][j] != image[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

}
