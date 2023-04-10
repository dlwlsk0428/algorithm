import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = bf.readLine();
		Stack<Character> head = new Stack<>();
		Stack<Character> tail = new Stack<>();
		
		for(int i = 0; i<s.length(); i++) {
			head.push(s.charAt(i));
		}
		
		int n = Integer.parseInt(bf.readLine());
		for(int i = 0; i<n; i++) {
			String cmd = bf.readLine();
			if(cmd.charAt(0) == 'L') {
				if(!head.isEmpty()) tail.push(head.pop());
			}
			else if(cmd.charAt(0) == 'D') {
				if(!tail.isEmpty()) head.push(tail.pop());
			}
			else if(cmd.charAt(0) == 'B') {
				if(!head.isEmpty()) head.pop();
			}
			else if(cmd.charAt(0) == 'P') {
				char ch = cmd.charAt(2);
				head.push(ch);
			}
		}
		
		while(!head.isEmpty()) tail.push(head.pop());
		
		StringBuilder sb = new StringBuilder();
		while(!tail.isEmpty()) sb.append(tail.pop());
		
		System.out.println(sb);
	}
}
