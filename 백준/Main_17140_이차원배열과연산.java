package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;
/*
 * 이차원 배열과 연산
 * 난 320 나왔는데... 108 나온 사람은 어케한거임;;;
 * 사실 어케한진 알겠는데... map 쓰고 list 쓰고 별 짓 다해서 그런듯ㅋㅋㅎ
 * class 만들면 적게 나올것같긴한데 귀찮아서 못하겠음;;;
 */
public class Main_17140_이차원배열과연산 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		int A[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int time = 0; time <= 100; time++) {
			if (r < A.length && c<A[0].length && A[r][c] == k) {
				System.out.println(time);
				return;
			}

			if (A.length >= A[0].length) {
				A = R(A);
			} else {
				A = C(A);
			}
		}

		System.out.println(-1);
	}

	static int[][] R(int[][] A) {
		HashMap<Integer, Integer> map[] = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>();
		}

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 0)
					continue;
				map[i].merge(A[i][j], 1, Integer::sum);
			}
			max = Math.max(max, map[i].size());
		}

		if (max > 50)
			max = 50;
		List<Entry<Integer, Integer>> list[] = new ArrayList[A.length];
		for (int i = 0; i < A.length; i++) {
			list[i] = new ArrayList<Entry<Integer, Integer>>(map[i].entrySet());
			list[i].sort((o1, o2) -> o1.getValue() != o2.getValue() ? o1.getValue() - o2.getValue()
					: o1.getKey() - o2.getKey());
		}

		int newA[][] = new int[A.length][max * 2];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < max; j++) {
				if (j >= list[i].size()) {
					newA[i][2 * j] = 0;
					newA[i][2 * j + 1] = 0;
				} else {
					newA[i][2 * j] = list[i].get(j).getKey();
					newA[i][2 * j + 1] = list[i].get(j).getValue();
				}
			}
		}

		return newA;
	}

	static int[][] C(int[][] A) {
		HashMap<Integer, Integer> map[] = new HashMap[A[0].length];
		for (int i = 0; i < A[0].length; i++) {
			map[i] = new HashMap<>();
		}

		int max = 0;
		for (int i = 0; i < A[0].length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j][i] == 0)
					continue;
				map[i].merge(A[j][i], 1, Integer::sum);
			}
			max = Math.max(max, map[i].size());
		}

		if (max > 50)
			max = 50;
		List<Entry<Integer, Integer>> list[] = new ArrayList[A[0].length];
		for (int i = 0; i < A[0].length; i++) {
			list[i] = new ArrayList<Entry<Integer, Integer>>(map[i].entrySet());
			list[i].sort((o1, o2) -> o1.getValue() != o2.getValue() ? o1.getValue() - o2.getValue()
					: o1.getKey() - o2.getKey());
		}

		int newA[][] = new int[max * 2][A[0].length];
		for (int i = 0; i < A[0].length; i++) {
			for (int j = 0; j < max; j++) {
				if (j >= list[i].size()) {
					newA[2 * j][i] = 0;
					newA[2 * j + 1][i] = 0;
				} else {
					newA[2 * j][i] = list[i].get(j).getKey();
					newA[2 * j + 1][i] = list[i].get(j).getValue();
				}
			}
		}

		return newA;
	}

}