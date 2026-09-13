class Solution {
    public long solution(int a, int b) {
        long count = Math.abs(a - b) + 1;
        return count * (a + b) / 2;
    }
}