/**
* 제한 사항
* 1 <= s <= 100
*
* 시간 복잡도
* O(1)
**/
class Solution {
    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;
        return (len % 2 == 0) ? s.substring(mid - 1, mid + 1) : s.substring(mid, mid + 1);
    }
}