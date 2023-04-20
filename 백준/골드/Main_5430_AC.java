import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5430_AC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int T = Integer.parseInt(bf.readLine());
		for(int test = 0; test < T; test++) {
			sb = new StringBuilder();
			String s = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			String[] arr;
			String a = bf.readLine();
			if(n==0) arr = new String[0];
			else {
				arr = a.split(",");
				arr[0] = arr[0].substring(1);
				arr[n-1] = arr[n-1].replace("]", "");
			}
			
			boolean error = false, dir = true;
			int head = 0, tail = n; 
			for(char c : s.toCharArray()) {
				if(c == 'D') {
					if(tail <= head) {
						error = true;
						System.out.println("error");
						break;
					} else if(dir) {
						head++;
					} else {
						tail--;
					}
				} else {
					dir = !dir;
				}
				
			}
			
			if(!error) {
				sb.append("[");
				if(dir) {
					for(int i = head; i<tail; i++) {
						sb.append(arr[i] );
						if(i < tail - 1) sb.append(",");
					}
				}
				else {
					for(int i = tail-1; i>=head; i--) {
						sb.append(arr[i]);
						if(i > head) sb.append(",");
					}
				}
				sb.append("]");
				
				System.out.println(sb);
			}
		}
	}
}
