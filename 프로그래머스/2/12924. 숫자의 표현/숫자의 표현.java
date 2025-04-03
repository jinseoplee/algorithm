class Solution {
    public int solution(int n) {
        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while (end < n) {
            if (sum == n) {
                count++;
                sum += ++end;
            } else if (sum < n) {
                sum += ++end;
            } else {
                sum -= start++;
            }
        }
        
        return count;
    }
}