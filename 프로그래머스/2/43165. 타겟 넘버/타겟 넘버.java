class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    // DFS를 사용하여 각 숫자에 대해 더하거나 빼면서 타겟 넘버를 만들 수 있는 방법의 수를 구한다.
    public int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            return target == sum ? 1 : 0;
        }
        
        return dfs(numbers, target, idx + 1, sum + numbers[idx])
            + dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}