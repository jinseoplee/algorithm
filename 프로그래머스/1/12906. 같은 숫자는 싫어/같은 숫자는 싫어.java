import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for (int e : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) != e) {
                list.add(e);
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}