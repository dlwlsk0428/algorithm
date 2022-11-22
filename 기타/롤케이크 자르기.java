package 기타;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : topping) {
            if(!map.containsKey(i)) map.put(i, 1);
            else {
                count = map.get(i);
                map.put(i, count + 1);
            }
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i : topping) {
            set.add(i);
            count = map.get(i);
            if(count == 1) map.remove(i);
            else map.put(i, count-1);
            if(set.size() == map.size()) answer++;
            else if(set.size() > map.size()) break;
        }
        
        return answer;
    }
}
