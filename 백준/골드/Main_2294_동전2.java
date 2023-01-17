import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int A[] = new int[100001];
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i<n; i++) {
			int coin = Integer.parseInt(bf.readLine());
			set.add(coin);
		}
		
		A[0] = 0;
		for(int coin : set) {
			A[coin] = 1;
			for(int j = 1; j<=k - coin; j++){
				if(A[j] == 0) continue;
				if(A[j + coin] == 0) A[j + coin] = A[j] + 1;
				else A[j + coin] = Math.min(A[j] + 1, A[j + coin]);
			}
		}
		
		System.out.println(A[k] == 0 ? -1 : A[k]);
	}

}
