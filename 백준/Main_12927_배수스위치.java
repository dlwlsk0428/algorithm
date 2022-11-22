package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 배수스위치
 */
public class Main_12927_배수스위치 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		boolean bulb[] = new boolean[s.length() + 1];
		
		for(int i = 1; i<bulb.length; i++) {
			bulb[i] = s.charAt(i-1) == 'Y' ? true: false;
		}
		
		int answer = 0;
		for(int i = 1; i<bulb.length; i++) {
			if(bulb[i]) {
				for(int j = 1; j<bulb.length; j++) {
					if(j % i == 0) {
						bulb[j] = !bulb[j];
					}
				}
				answer++;
			}
		}
		 System.out.println(answer);	
	}

}