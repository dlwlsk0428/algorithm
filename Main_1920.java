import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int []A = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(bf.readLine());
		int []B = new int[M];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<M; i++) {
			if(Arrays.binarySearch(A, B[i]) < 0) System.out.println(0);
			else System.out.println(1);
		}
	}

}
