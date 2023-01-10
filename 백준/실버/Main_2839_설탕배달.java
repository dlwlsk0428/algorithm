import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int n = 0;
		while(N>0) {
			if(N % 5 == 0) {
				N -= 5;
				n++;
			}
			else if(N%3 == 0) {
				N -= 3;
				n++;
			}
			else if(N>5) {
				N-=5;
				n++;
			}
			else {
				n = -1;
				break;
			}
		}
		System.out.println(n);
	}

}
