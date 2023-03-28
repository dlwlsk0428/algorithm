import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
		for(int i = 0; i<n; i++) {
			map.put(bf.readLine(), 0);
		}
		
		for(int i = 0; i<m; i++) {
			String s = bf.readLine();
			if(map.containsKey(s)) queue.offer(s);
		}
		
		System.out.println(queue.size());
		while(!queue.isEmpty()) System.out.println(queue.poll());

	}
}
