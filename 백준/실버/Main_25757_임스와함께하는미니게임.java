import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_25757_임스와함께하는미니게임 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		int num = game == 'Y' ? 1 : game == 'F' ? 2 : 3;
		
		Set<String> name = new HashSet<>();
		for(int i = 0; i<N; i++) {
			name.add(bf.readLine());
		}

		System.out.println(name.size() / num);
	}
}
