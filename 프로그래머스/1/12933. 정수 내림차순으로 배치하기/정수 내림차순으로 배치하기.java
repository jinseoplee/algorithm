class Solution {
    public long solution(long n) {
        int[] count = new int[10];
        
        while (n > 0) {
            count[(int) (n % 10)]++;
            n /= 10;
        }
        
        long answer = 0;
        for (int i = 9; i >= 0; i--) {
           for (int j = 0; j < count[i]; j++) {
               answer = answer * 10 + i;
           }
        }
        
        return answer;
    }
}