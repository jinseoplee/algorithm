import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 크기별 개수를 카운트
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // 개수를 리스트로 반환하고 내림차순 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        // 개수가 많은 귤부터 선택하여 종류의 최솟값을 구한다
        int answer = 0;
        for (int i : list) {
            k -= i;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}