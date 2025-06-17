import java.util.*;

public class Solution {
    public int solution(int n) {
        int usage = 0;
        
        while (n != 0) {
            // 현재 위치가 짝수라면 순간이동
            if (n % 2 == 0) {
                n /= 2;
            } 
            // 현재 위치가 홀수라면 1칸 점프
            else {
                n--;
                usage++;
            }
        }
        
        return usage;
    }
}