import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 연산자 끼워넣기
 * 백트래킹
 */
public class Main_14888_연산자끼워넣기 {

	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine());
		int number[] = new int[N];
		for(int i = 0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int operator[] = new int[4];
		int selected[] = new int[4];
		for(int i = 0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		calculate(0, number[0], number, operator, selected);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void calculate(int n, int sum, int number[], int operator[], int selected[]) {
		if(n == number.length - 1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i<4; i++) {
			if(selected[i] < operator[i]) {
				selected[i]++;
				if(i == 0) calculate(n+1, sum+number[n+1], number, operator, selected);
				if(i == 1) calculate(n+1, sum-number[n+1], number, operator, selected);
				if(i == 2) calculate(n+1, sum*number[n+1], number, operator, selected);
				if(i == 3) {
					if(sum < 0) {
						sum = -1 * sum / number[n+1];
						sum *= -1;
					} else sum /= number[n+1];
					calculate(n+1, sum, number, operator, selected);
				}
				selected[i]--;
			}
		}
	}
}