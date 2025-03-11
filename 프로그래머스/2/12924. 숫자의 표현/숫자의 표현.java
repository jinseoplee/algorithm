class Solution {
    public int solution(int n) {
        // 투 포인터를 사용하여 문제 풀이
        int cnt = 0;
        int sum = 1;
        int start = 1;
        int end = 1;
        
        while (end <= n) {
            if (sum == n) {
                cnt++;
                sum += ++end;
            } else if (sum < n) {
                sum += ++end;
            } else {
                sum -= start++;
            }
        }
        
        return cnt;
    }
}