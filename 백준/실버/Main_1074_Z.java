import java.util.Scanner;

public class Main_1074_Z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt(), c = sc.nextInt(), i = 0, j = 0;
		double row = Math.pow(2, N), col = Math.pow(2, N);
		double answer = 0;
		int start = 0, end = (int)(row * col) - 1;
		
		while(N-- > 0) {
			row /= 2;
			col /= 2;
			// 4사분면
			if(r >= row && c >= col) {
				answer += Math.pow(4, N) * 3;
				r -= row;
				c -= col;
			}
			// 3사분면
			else if(r >= row && c < col) {
				answer += Math.pow(4, N) * 2;
				r -= row;
			}
			// 2사분면
			else if(r < row && c >= col) {
				answer += Math.pow(4, N) * 1;
				c-=col;
			}
		}
		System.out.println((int)answer);
	}

}
