package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
/*
 * 영단어 암기는 괴로워
 * -> 영단어 암기가 아니라 시간 초과가 괴롭다ㅜㅠㅠ
 */
public class Main_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String word = bf.readLine();
			if(word.length() < M) continue; 
			map.merge(word,1, Integer::sum);
		}
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		list.sort((w1, w2) -> 
		w1.getValue() != w2.getValue() ? w2.getValue() - w1.getValue() : (w1.getKey().length() != w2.getKey().length()? w2.getKey().length() - w1.getKey().length() : w1.getKey().compareTo(w2.getKey()))
		);
		
		for(Entry<String, Integer> word : list) {
			bw.write(word.getKey() + "\n");
		}
		bw.flush();
		bw.close();
	}
}