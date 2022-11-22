package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 톱니바퀴
 */
public class Main_14891_톱니바퀴 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String gear[] = new String[4];
		int gearTop[] = new int [4];
		int tmp[] = new int[4];
		for(int i = 0; i<gear.length; i++) {
			gear[i] = bf.readLine();
			gearTop[i] = 0;
		}
		
		int N = Integer.parseInt(bf.readLine());
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(bf.readLine());
			int gearNum = Integer.parseInt(st.nextToken()) - 1;
			int rotate = Integer.parseInt(st.nextToken());
			
			tmp[gearNum] = (gearTop[gearNum] + 8 - rotate) % 8;
			
			int r = rotate;
			for(int i = gearNum - 1; i>= 0; i--) {
				if(gear[i+1].charAt((gearTop[i + 1] + 6) % 8) == gear[i].charAt((gearTop[i] + 2) % 8)) {
					break;
				}
				r *= -1;
				tmp[i] = (gearTop[i] + 8 - r) % 8;
			}
			
			r = rotate;
			for(int i = gearNum + 1; i<4; i++) {
				if(gear[i-1].charAt((gearTop[i - 1] + 2) % 8) == gear[i].charAt((gearTop[i] + 6) % 8)) {
					break;
				}
				r *= -1;
				tmp[i] = (gearTop[i] + 8 - r) % 8;
			}
			
			for(int i = 0; i<4; i++) {
				gearTop[i] = tmp[i];
			}
		}
		
		int point = 0;
		for(int i = 0; i<gear.length; i++) {
			if(gear[i].charAt(gearTop[i]) == '1') point += Math.pow(2, i);
		}
		System.out.println(point);
	}
	
}