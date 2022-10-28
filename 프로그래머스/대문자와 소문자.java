/**
* 한줄로 풀어보기
*/
class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char c : my_string.toCharArray()) answer+=Character.toString(c<'a'? c + 32 : c-32);
        return answer;
    }
}
