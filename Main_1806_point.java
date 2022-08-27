import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 부분합 - 포인트로
 */
public class Main_1806_point {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int num[] = new int[N];
		
		st= new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0, end = 0;
		while(true) {
			if(sum >= S) {
				sum -= num[start];
				answer = Math.min(answer, end - start);
				start++;
			}
			else if(end == N) break;
			else sum += num[end++];
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0: answer);
	}
}