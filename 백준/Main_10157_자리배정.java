package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 자리배정
 */
public class Main_10157_자리배정 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int C = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(bf.readLine());
		
		if(K > R*C) {
			System.out.println(0);
			return;
		}
		
		int i = 0;
		while(true) {
			if(R - 2*i <= 0 || C - 2*i <= 0) break;
			i++;
			int n = 0;
			if(R - 2*i >= 0 && C - 2*i >= 0) n = (R - 2* i) * (C - 2* i);
			
			if(R*C - n >= K) break;
		}
		
		i--;
		int start = R*C - ((R - 2* i) * (C - 2* i)) + 1;
		int r = i + 1, c = i + 1;
				
		int n = 0;
		R = R - 2*i; C = C-2*i;
		while(start + n != K) {
			n++;
			if(n<R) c++;
			else if (n < R + C - 1) r++;
			else if (n < 2*R + C - 2) c--;
			else r --;
		}
		
		System.out.println(r + " " + c);
	}

}