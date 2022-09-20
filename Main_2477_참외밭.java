import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 참외밭
 * 처음에 방향이 두개 있는거 사이에 값을 작은 네모의 가로 세로로 생각했는데 그럼 1, 5 이럴때 안됐다...
 */
public class Main_2477_참외밭 {

	public static void main (String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(bf.readLine());
		int area[][] = new int [7][2];
		boolean visited[] = new boolean [6];
		int row = 0, col = 0, rowIdx = -1, colIdx = -1;
		for(int i = 0; i<6; i++) {
			st = new StringTokenizer(bf.readLine());
			area[i][0] = Integer.parseInt(st.nextToken());
			area[i][1] = Integer.parseInt(st.nextToken());
			if((area[i][0] == 2 || area[i][0] == 1) && row < area[i][1]) {
				row = area[i][1];
				rowIdx = i;
			}
			if((area[i][0] == 3 || area[i][0] == 4) && col < area[i][1]) {
				col = area[i][1];
				colIdx = i;
			}
		}
		
		for(int i = -1; i<=1; i++) {
			visited[(6 + rowIdx + i) % 6] = true;
			visited[(6 + colIdx + i) % 6] = true;
		}
				
		int smallArea = 1;
		for(int i = 0; i<6; i++) {
			if(!visited[i]) smallArea *= area[i][1];
		}
		
		System.out.println((row * col - smallArea) * K);
	}

}
