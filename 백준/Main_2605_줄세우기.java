package 백준;

import java.util.Scanner;
import java.util.Stack;

/*
 * 줄 세우기
 */
public class Main_2605_줄세우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack_tmp = new Stack<>();
		
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			int k = sc.nextInt();
			for(int j = 0; j<k; j++) {
				stack_tmp.push(stack.pop());
			}
			stack.push(i);
			for(int j = 0; j<k; j++) {
				stack.push(stack_tmp.pop());
			}
			
		}
		
		String ans = "";
		for(int i = 0; i<n; i++) {
			ans = stack.pop() + " " + ans;
		}
		
		System.out.println(ans);
	}

}
