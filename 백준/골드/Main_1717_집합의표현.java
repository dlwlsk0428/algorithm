import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {

	public static int num[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		num = new int[n+1];
		for(int i = 1; i<n+1; i++) num[i] = i;
		int type, a, b;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			type = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(type == 0) union(a, b);
			else if(find(a) == find(b)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static int find(int x) {
		if(num[x] == x) return x;
		else return num[x] = find(num[x]);
	}
	
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x > y) num[x] = y;
		else num[y] = x;
	}
}
