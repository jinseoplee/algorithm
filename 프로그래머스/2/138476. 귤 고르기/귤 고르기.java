import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>(); // size, count
        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1));
        
        int count = 0;
        for (int e : list) {
            k -= e;
            count++;
            if (k <= 0) break;
        }
        return count;
    }
}