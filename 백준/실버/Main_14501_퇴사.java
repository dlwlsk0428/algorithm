import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static boolean check[];
	public static int answer = 0;
	public static int Tn[], Pn[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Tn = new int[n];
		Pn = new int[n];
		check = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Tn[i] = Integer.parseInt(st.nextToken());
			Pn[i] = Integer.parseInt(st.nextToken());
		}
		
		find(0, 0);
		
		System.out.println(answer);
	}
	
	public static boolean able(int idx) {
		for(int i = 0; i<Tn[idx]; i++) {
			if(idx+i >= check.length || check[idx + i]) return false;
		}
		return true;
	}
	
	public static void find(int idx, int money) {
		if(idx == check.length) {
			answer = Math.max(answer, money);
			return;
		}
		
		if(able(idx)) {
			for(int i = 0; i<Tn[idx]; i++) check[idx + i] = true;
			find(idx+Tn[idx]-1, money + Pn[idx]);
			for(int i = 0; i<Tn[idx]; i++) check[idx + i] = false;
		}
		find(idx+1, money);
	}

}
