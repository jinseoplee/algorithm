class Solution {
    public int solution(int n) {
        int countOfOneInN = Integer.bitCount(n); // n의 1의 개수
        
        for (int nextNumber = n + 1; nextNumber <= 1000000; nextNumber++) { // n보다 큰 자연수부터 시작
            int countOfOneInNext = Integer.bitCount(nextNumber); // nextNumber의 1의 개수
            if (countOfOneInN == countOfOneInNext) {
                return nextNumber;
            }
        }
        
        return -1;
    }
}