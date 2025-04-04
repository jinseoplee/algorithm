class Solution {
    public int solution(int n) {
        int bitCount = Integer.bitCount(n);
        while (true) {
            n++; // 다음 숫자부터 시작
            if (bitCount == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}