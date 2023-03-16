import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1699_제곱수의합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int num[] = new int[n+1];
		for(int i = 1; i<num.length; i++) num[i] = 100001;
		
		int end = (int) Math.sqrt(n) + 1;
		
		for(int i = 1; i<=end; i++) {
			int k = i * i;
			for(int j = 0; j<num.length; j++) {
				if(j + k > n) break;
				num[j+k] = Math.min(num[j+k], num[j] + 1);
			}
		}
		
//		for(int i = 1; i<num.length;i++) System.out.println(num[i]);
		System.out.println(num[n]);
	}
}
