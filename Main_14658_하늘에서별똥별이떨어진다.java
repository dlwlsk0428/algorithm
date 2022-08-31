import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 하늘에서 별똥별이 떨어진다
 * 첨에 별똥별 탐색을 map으로 해서 메모리 초과 남...
 */
public class Main_14658_하늘에서별똥별이떨어진다 {
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sstarx[] = new int[K];
		int sstary[] = new int[K];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sstarx[i] = x;
			sstary[i] = y;
		}
		
		int answer = 0;
		for(int i = 0; i<K; i++) {
			for(int j = 0; j<K; j++) {
				int star = 0;
				int x = sstarx[i];
				int y = sstary[j];
				for(int k = 0; k<K; k++) {
					if(sstarx[k] >= x && sstarx[k] <= x+L && sstary[k] >= y && sstary[k] <= y+L) star++;
				}
				
				answer = Math.max(answer, star);
				if(answer == K) {
					System.out.println(0);
					return;
				}
			}
		}
		
		System.out.println(K-answer);
	}
}