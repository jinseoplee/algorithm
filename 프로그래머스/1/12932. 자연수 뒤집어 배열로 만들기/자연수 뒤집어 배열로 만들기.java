/**
* 1 <= n <= 10,000,000,000
*
* 시간 복잡도 = O(n의 자릿수)
*/
class Solution {
    public int[] solution(long n) {
        int length = (n + "").length();
        int[] arr = new int[length];
        
        for (int i = 0; i < length; i++) {
            int r = (int) (n % 10);
            arr[i] = r;
            n /= 10;
        }
        
        return arr;
    }
}