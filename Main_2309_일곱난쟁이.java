import java.util.Arrays;
import java.util.Scanner;

/*
 * 일곱난쟁이
 */
public class Main_2309_일곱난쟁이 {

	static int height[];
	static boolean selected[];
	static int answer[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = 9;
		height = new int[n];
		selected = new boolean[n];
		answer = new int[7];
		for(int i = 0; i<n; i++) {
			height[i] = sc.nextInt();
		}
		
		find(0, 0, 0);
		
		Arrays.sort(answer);
		for(int i = 0; i<7; i++){
			System.out.println(answer[i]);
		}
	}
	
	static void find(int i, int n, int total) {
		if(total > 100) return;
		if(i == 9 && n<7) return;
		if(n == 7) {
			if(total == 100) ans();
			return;
		}
		selected[i] = true;
		find(i+1, n+1, total+height[i]);
		selected[i] = false;
		find(i+1, n, total);
	}
	
	static void ans() {
		int index = 0;
		for(int i = 0; i<9; i++) {
			if(selected[i] == true) {
				answer[index++] = height[i]; 
			}
		}
	}
}
