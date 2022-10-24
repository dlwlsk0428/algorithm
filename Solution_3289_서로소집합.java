import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_3289_서로소집합
{
	static int n, m;
	static int []arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			for(int i = 1; i<=n; i++) {
				arr[i] = i;
			}
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int func = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(func == 1) {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
				else if(func == 0) {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean union(int a, int b) {
		int setA = find(a);
		int setB = find(b);
		
		if(setA == setB) return false;
		
		if(setA < setB) arr[setB] = setA;
		else arr[setA] = setB;
		
		return true;
	}
	
	static int find(int x) {
		if(x == arr[x]) return x;
		return arr[x] = find(arr[x]);
	}
}