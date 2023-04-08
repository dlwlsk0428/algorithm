import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158_요세푸스문제 {

	static int k, n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); k = sc.nextInt();
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 1; i<=n; i++) {
			queue.offer(i);
		}
		
		System.out.print("<");
		while(true) {
			for(int i = 0; i<k - 1; i++) {
				queue.offer(queue.poll());
			}
			
			System.out.print(queue.poll());
			
			if(queue.isEmpty()) {
				System.out.print(">");
				break;
			} else System.out.print(", ");
		}
	}

}
