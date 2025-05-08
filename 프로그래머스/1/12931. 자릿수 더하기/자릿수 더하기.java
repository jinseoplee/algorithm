import java.util.*;

/**
* 1 <= n <= 1,000,000,000
* 
* 시간 복잡도: O(n의 자릿수)
*/
public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n != 0) {
            answer += n % 10;
            n = n / 10;
        }
        
        return answer;
    }
}