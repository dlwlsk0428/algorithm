import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * 빙고
 */
public class Main_2578_빙고 {

	static int[][] bingoMap = new int[5][5];
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static int bingo[] = new int[12];
	static int win;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingoMap[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				queue.offer(sc.nextInt());
			}
		}
		
		while(win < 3) {
			search(queue.poll());
		}
		
		System.out.println(25-queue.size());
	}
	
	static void search(int n) {
		for(int i = 0; i<5; i++){
			for(int j =0; j<5; j++) {
				if(bingoMap[i][j] == n) {
					if(++bingo[i] == 5) win++;
					if(++bingo[j + 5] == 5) win++;
					if(i == j && ++bingo[10] == 5) win++;
					if(i+j == 4 && ++bingo[11] == 5) win++;
				}
			}
		}
	}
}
