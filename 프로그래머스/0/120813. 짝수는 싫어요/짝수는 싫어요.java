import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        return IntStream.iterate(1, i -> i <= n, i -> i + 2)
                        .toArray();
    }
}