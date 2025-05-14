import java.util.*;

/**
* 우선순위 큐를 이용한 풀이
* 시간 복잡도: O(n log n)
*/
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int times = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1 + (s2 * 2));
            times++;
        }
        
        return pq.peek() >= K ? times : -1;
    }
}