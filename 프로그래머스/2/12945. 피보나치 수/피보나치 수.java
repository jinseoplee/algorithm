class Solution {
    public int solution(int n) {
        // 재귀로 풀 경우 시간 초과 발생
        // DP를 이용하여 문제 풀이
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}