import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ZOAC 4 - 거리두기 문제
 * 가로 세로 헷갈려서 틀림;;;
 */
public class Main_23971_거리두기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W= Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int r = (H / (N+1)) + (H%(N+1) == 0 ? 0 : 1);
		int c = (W / (M+1)) + (W%(M+1) == 0 ? 0 : 1);
		
		System.out.println(r*c);
	}

}