class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int acc) {
        if (idx == numbers.length) {
            return target == acc ? 1 : 0;
        }
        
        return dfs(numbers, target, idx + 1, acc + numbers[idx])
             + dfs(numbers, target, idx + 1, acc - numbers[idx]);
    }
}