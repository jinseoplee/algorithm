import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for (int e : d) {
            budget -= e;
            if (budget < 0) break;
            answer++;
        }
        
        return answer;
    }
}