class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String str = "";
        for(int i : array) str += i;
        answer = str.length();
        return answer - str.replace("7", "").length();
    }
}
