import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_7465_창용마을무리의개수
{
	static int friend[];
	static int n, m;
	static int group;
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			friend = new int[n+1];
			for(int i = 1; i<=n; i++) {
				friend[i] = i;
			}
			group = n;
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			System.out.printf("#%d %d\n", test_case, group);
		}
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) friend[bRoot] = aRoot;
		else friend[aRoot] = bRoot;
		group--;
		return true;
	}
	
	static int find(int x) {
		if(friend[x] == x) return x;
		return friend[x] = find(friend[x]);
	}
	
}
