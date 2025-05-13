/**
* 1 <= n <= 2,000
*
* DP 풀이 = O(n)
*/
class Solution {
    public long solution(int n) {
        int prev2 = 1;
        int prev1 = 1;
        int current = 1;
        
        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % 1234567; // f(n) = f(n - 1) + f(n - 2);
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}