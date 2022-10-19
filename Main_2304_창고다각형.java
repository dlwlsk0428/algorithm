import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 * 창고 다각형
 */
public class Main_2304_창고다각형 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int [][] garages = new int [N][2];
		for(int i = 0; i< N; i++){
			st = new StringTokenizer(bf.readLine());
			garages[i][0] = Integer.parseInt(st.nextToken());
			garages[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(garages, Comparator.comparingInt(o1 -> o1[0]));
		int max = 0, maxIdx = 0;
		for(int i = 0; i< N; i++){
			if(max<garages[i][1]) {
				max = garages[i][1];
				maxIdx = i;
			}
		}
		
		int start = garages[0][0], middle = garages[maxIdx][0], end = garages[N-1][0], answer = 0;
		int maxH = -1, index = 0;
		for(int i = start; i<=middle; i++) {
			if(garages[index][0] == i) {
				maxH = Math.max(maxH, garages[index++][1]);
			}
			answer += maxH;
		}
		maxH = -1; index = N-1;
		for(int i = end; i>middle; i--) {
			if(garages[index][0] == i) {
				maxH = Math.max(maxH, garages[index--][1]);
			}
			answer += maxH;
		}
		System.out.println(answer);
	}

}
