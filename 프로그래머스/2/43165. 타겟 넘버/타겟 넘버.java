/**
* 제한 사항
* 2 <= numbers 길이 <= 20
* 1 <= numbers[i] <= 50
* 1 <= target <= 1000
*
* DFS 풀이 = O(2^(numbers.length))
*/
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int idx, int acc) {
        if (idx == numbers.length) { // 종료 조건
            if (target == acc) return 1; // 타겟 넘버를 만들 수 있는 경우
            return 0;
        }
        
        int count = 0;
        count += dfs(numbers, target, idx + 1, acc + numbers[idx]); // +
        count += dfs(numbers, target, idx + 1, acc - numbers[idx]); // -
        
        return count;
    }
}