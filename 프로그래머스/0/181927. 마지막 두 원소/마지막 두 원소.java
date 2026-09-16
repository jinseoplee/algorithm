import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int last = num_list[length - 1];
        int prev = num_list[length - 2];
        
        int[] answer = Arrays.copyOf(num_list, length + 1);
        answer[length] = last > prev ? last - prev : last * 2;
        
        return answer;
    }
}