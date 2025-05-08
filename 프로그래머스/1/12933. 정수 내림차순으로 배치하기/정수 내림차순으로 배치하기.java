import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = (n + "").toCharArray();
        String str = "";
        
        // 정렬
        Arrays.sort(arr);
        
        for (int i = arr.length - 1; i >= 0; i--) {
            str += arr[i];
        }
        return Long.valueOf(str);
    }
}