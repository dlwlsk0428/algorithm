import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String s : s1) {
            if(Arrays.asList(s2).indexOf(s) >= 0) answer++;
        }
        return answer;
    }
}
