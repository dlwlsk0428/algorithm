import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 개미
 * java 11 -> 시간 초과 / java 8 -> 잘됨... 왜지
 */
public class Main_10158_개미 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(bf.readLine());
		
		x =((t+x)/row) % 2 == 0? (t + x) % row : row - (t + x) % row;
		y =((t+y)/col) % 2 == 0? (t + y) % col : col - (t + y) % col;
		System.out.println(x + " " + y);
	}
}
