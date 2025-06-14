class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int num = left; num <= right; num++) {
            if (isPerfectSquare(num)) {
                answer -= num;
            } else {
                answer += num;
            }
        }
        
        return answer;
    }
    
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}