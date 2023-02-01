import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461_파도반수열 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			long P[] = new long[N+1];
			if(N > 0) P[1] = 1;
			if(N > 1) P[2] = 1;
			if(N > 2) P[3] = 1;
			if(N > 3) P[4] = 2;
			if(N > 4) P[5] = 2;
			for(int i = 6; i<=N; i++) {
				P[i] = P[i-1] + P[i-5];
			}
			System.out.println(P[N]);
		}

	}

}
