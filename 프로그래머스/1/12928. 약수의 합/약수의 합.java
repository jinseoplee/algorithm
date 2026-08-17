class Solution {
    public int solution(int n) {
        int sum = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += (i * i == n) ? i : i + (n / i);
            }
        }
        
        return sum;
    }
}