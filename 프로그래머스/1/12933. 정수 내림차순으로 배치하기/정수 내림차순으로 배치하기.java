import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr); // 오름차순 정렬
        
        String str = new StringBuilder(new String(arr))
            .reverse()
            .toString();
        
        return Long.parseLong(str);
    }
}