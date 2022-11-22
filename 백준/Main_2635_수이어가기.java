package 백준;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 수 이어가기
 * > 음의 정수만 버리는거라 0은 포함...
 */
public class Main_2635_수이어가기 {
	static int answer, select;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second, num, next, tmp;
		int start = first/2<1?1:first/2;
		int last = (first/3) * 2 + 2;
		for(int i = start; i<last; i++) {
			second = i; 
			num = 2;
			next = first - second;
			while(next >= 0) {
				num++;
				tmp = next;
				next = second - next;
				second = tmp;
			}
			if(answer < num) {
				answer = num;
				select = i;
			}
		}
		System.out.println(answer);
		System.out.print(first + " " + select);
		second = select;
		next = first - second;
		while(next >= 0) {
			System.out.print(" "+next);
			tmp = next;
			next = second - next;
			second = tmp;
		}
	}

}
