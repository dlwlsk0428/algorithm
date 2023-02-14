import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22388_改元 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String g = st.nextToken();
			if(g.equals("#")) break;
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(y > 31 || (y == 31 && m > 4)) {
				y -= 30;
				g = "?";
			}
			
			System.out.printf("%s %d %d %d\n", g, y, m, d);
		}
	}

}
