class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    static void dfs(int [] numbers, int n, int num, int target){
        if(n == numbers.length){
            if(target == num){
                answer++;
            }
            return;
        }
        dfs(numbers, n+1, num + numbers[n], target);
        dfs(numbers, n+1, num - numbers[n], target);
    }
    
}
