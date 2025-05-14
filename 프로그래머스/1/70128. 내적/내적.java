/**
* 제한 사항
* 1 <= a, b 길이 <= 1,000
* -1,000 <= a, b의 모든 수 <= 1,000
*
* 시간 복잡도
* O(n), n은 배열 a 또는 b의 길이
**/
class Solution {
    public int solution(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}