import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		double num[] = new double[n];
		String str = bf.readLine();
		
		for(int i = 0; i<n; i++) {
			num[i] = Double.parseDouble(bf.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		stack.push(num[str.charAt(0) - 'A']);
		stack.push(num[str.charAt(1) - 'A']);
		
		int now = 2;
		long answer = 0;
		
		while(now < str.length()) {
			if(str.charAt(now) >= 'A' && str.charAt(now) <= 'Z') stack.push(num[str.charAt(now) - 'A']);
			else {
				double b = stack.pop();
				double a = stack.pop();
				
				if(str.charAt(now) == '+') stack.push(a + b);
				else if(str.charAt(now) == '-') stack.push(a - b);
				else if(str.charAt(now) == '*') stack.push(a * b);
				else stack.push(a/b);
			}
			
			now++;
		}
		
		System.out.printf("%.2f",stack.pop());
	}
}
