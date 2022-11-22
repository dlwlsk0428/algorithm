package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 * 종이 자르기
 * 처음엔 경계를 기준으로 한쪽의 배열 값을 더해주는 방식으로 했다
 * 그랬더니 2 2 / 2 / 1 1 / 0 1의 경우
 * 0 1
 * 1 2
 * 이렇게 나와서 답이 2가 나왔었다
 * 그래서 arrayList에 r, c 를 다 넣고 곱해서 제일 큰 값을 찾는 방식으로 바꾸었다
 */
public class Main_2628_종이자르기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int C = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(bf.readLine());
		
		int paper[][] = new int [R][C];
		ArrayList<Integer> listR = new ArrayList<>();
		ArrayList<Integer> listC = new ArrayList<>();
		
		listR.add(0); listR.add(R);
		listC.add(0); listC.add(C);
		
		for(int n = 1; n<=N; n++) {
			st = new StringTokenizer(bf.readLine());
			char type = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			if(type == '0') {
				listR.add(num);
			}
			else if(type == '1') {
				listC.add(num);
			}
		}
		
		listR.sort(Comparator.reverseOrder());
		listC.sort(Comparator.reverseOrder());
		
		int max = 0;
		for(int i = 1; i<listR.size(); i++) {
			for(int j = 1; j < listC.size(); j++) {
				int square = (listR.get(i-1) - listR.get(i)) * (listC.get(j-1) - listC.get(j));
				max = Math.max(max, square);
			}
		}
		
		System.out.println(max);

	}

}