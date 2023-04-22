import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2751_수정렬하기2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		boolean num[] = new boolean[1000001];
		boolean min[] = new boolean[1000001];
		for(int i = 0; i<N; i++) {
			int n = Integer.parseInt(bf.readLine());
			if(n < 0) min[n * -1] = true;
			else num[n] = true;
		}
		
		for(int i = num.length-1; i>0; i--) {
			if(min[i]) sb.append("-").append(i).append("\n");
		}
		for(int i = 0; i<num.length; i++) {
			if(num[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}
