import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {

	static String alphabet[];
	static boolean used[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		alphabet = new String[C];
		ArrayList<String> list = new ArrayList<>();
		used = new boolean[C];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken();
		}
		Arrays.sort(alphabet);

		password(N, C, 0, "");

	}

	static void password(int N, int C, int n, String answer) {
		if (answer.length() == N) {
			char check[] = answer.toCharArray();
			int v = 0, c = 0;
			for(char ch : check) {
				if(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
					v++;
				else
					c++;
			}
			if(v>=1 && c>=2)
				System.out.println(answer);
			return;
		}
		if(n >= C) return;

		password(N, C, n+1, answer + alphabet[n]);
		password(N, C, n+1, answer);
	}

}
