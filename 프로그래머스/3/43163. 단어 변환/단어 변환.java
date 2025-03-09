import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // BFS를 사용해 begin을 target으로 변환하는 최소 횟수를 찾는다
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        
        Map<String, Integer> step = new HashMap<>(); // 단어, 변환 횟수를 저장
        step.put(begin, 0);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            
            // 목표 단어에 도달하면 변환 횟수를 반환한다
            if (curr.equals(target)) {
                return step.get(curr);
            }
            
            for (String next : words) {
                if (canChange(curr, next, step)) {
                    q.offer(next);
                    step.put(next, step.get(curr) + 1);
                }    
            }
        }
        
        // 목표 단어에 도달하지 못하면 0을 반환한다
        return 0;
    }
    
    private boolean canChange(String curr, String next, Map<String, Integer> step) {
        // 이미 방문한 단어는 제외
        if (step.containsKey(next)) {
            return false;
        }
        
        int diffCnt = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != next.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1; // 한 글자만 다르면 true 반환
    }
}