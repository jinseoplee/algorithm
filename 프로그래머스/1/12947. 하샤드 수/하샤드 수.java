class Solution {
    public boolean solution(int x) {
        // 각 자릿수의 합을 구한다
        int sum = 0;
        int tmp = x;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        // 하샤드 수인지 판별
        return x % sum == 0;
    }
}