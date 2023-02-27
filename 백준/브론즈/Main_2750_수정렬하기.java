import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2750_수정렬하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int num[] = new int[n];
		for(int i = 0; i<n; i++) num[i] = Integer.parseInt(bf.readLine());
		
		Arrays.sort(num);
		
		for(int i : num) System.out.println(i);
	}
}
