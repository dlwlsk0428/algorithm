class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        answer = new int[ch.length];
        for(int i = 0; i<ch.length; i++) answer[ch.length - i - 1] = ch[i] - '0';
        return answer;
    }
}
