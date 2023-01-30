import java.util.Arrays;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int now[] = scores[0];
        int max = Integer.MIN_VALUE;
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int i = 0; i<scores.length; i++) {
        	if(max <= scores[i][1]) max = scores[i][1];
        	else if(scores[i][0] == now[0] && scores[i][1] == now[1]) {
        		return -1;
        	} else continue;
        	
        	// 완호 순위 측정
        	if(scores[i][0]+scores[i][1] > now[0]+now[1]) answer++;
        }
        return answer;
    }
}
