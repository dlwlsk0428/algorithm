import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1463_1로만들기 {
	
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		calc(N, 0);
		
		System.out.println(answer);
		
	}
	
	static void calc(int n, int count) {
		if(n < 1) return;
		if(count > answer) return;
		if(n == 1) {
			answer = Math.min(answer, count);
		}
		
		
		if(n % 3 == 0) calc(n/3, count+1);
		if(n % 2 == 0) calc(n/2, count+1);
		calc(n-1, count+1);
	}

}
