import java.util.*;

/**
* 1 <= 배열의 크기 <= 1,000,000
* 1 <= 배열의 원소 <= 9
*
* 스택을 이용한 풀이 = O(배열의 크기)
*/
public class Solution {
    public int[] solution(int []arr) {
        List<Integer> stack = new ArrayList<>();
        
        for (int e : arr) {
            if (stack.isEmpty() || stack.get(stack.size() - 1) != e) {
                stack.add(e);
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}