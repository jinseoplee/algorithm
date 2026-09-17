import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; ; i++) {
            int n = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            
            if (n > r) {
                break;
            }
            
            if (n >= l) {
                list.add(n);
            }
        }
        
        return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(i -> i).toArray();
    }
}