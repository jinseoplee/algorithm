import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] newArr = Arrays.stream(arr)
            .filter(i -> i % divisor == 0)
            .sorted()
            .toArray();
        
        return newArr.length > 0 ? newArr : new int[] {-1};
    }
}