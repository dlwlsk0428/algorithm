import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 직사각형
 * 각변의 길이의 합과 제일 큰 좌표 - 제일작은 좌표 값을 비교하였다 
 * 첨에 테케 한개를 놓쳤다 / 0 0 2 2 3 2 4 4 => b 가 아니라 d 임
 * 나중에 추가된 테케같다. 그래서 첨에 99퍼에서 틀린듯 
 * 참고
 * https://www.acmicpc.net/board/view/35358 
 */
public class Main_2527_직사각형 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rec[] = new int[8];

		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 8; i++) {
				rec[i] = Integer.parseInt(st.nextToken());
			}

			int x = Math.max(rec[2], rec[6]) - Math.min(rec[0], rec[4]);
			int y = Math.max(rec[3], rec[7]) - Math.min(rec[1], rec[5]);
			
			int xa = rec[2] - rec[0], xb = rec[6] - rec[4];
			int ya = rec[3] - rec[1], yb = rec[7] - rec[5];
			
			if(x == xa+xb && y == ya+yb) {
				System.out.println("c");
			} else if ((x == xa+xb && y < ya+yb) || (x < xa+xb && y == ya+yb)) {
				System.out.println("b");
			}else if(x < xa+xb && y < ya+yb) {
				System.out.println("a");
			} else {
				System.out.println("d");
			}
		}
	}

}
