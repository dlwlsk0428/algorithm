class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(char c = 'a'; c <= 'z'; c++) {
            if(s.indexOf(c) < 0) continue;
            int n = -1;
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == c) {
                    answer[i] = n;
                    n = 1;
                }
                else if(n > -1) n++;
            }
        }
        return answer;
    }
}
