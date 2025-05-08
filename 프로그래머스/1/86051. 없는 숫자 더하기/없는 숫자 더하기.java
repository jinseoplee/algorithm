class Solution {
    public int solution(int[] numbers) {
        int sum = 45; // 0~9의 합
        for (int n : numbers) {
            sum -= n;
        }
        return sum;
    }
}