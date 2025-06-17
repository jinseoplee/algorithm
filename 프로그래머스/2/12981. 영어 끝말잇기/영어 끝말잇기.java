import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        // 중복 단어 확인을 위한 집합 자료구조
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            
            // 끝말잇기 규칙 체크
            if ((pre.charAt(pre.length() - 1) != cur.charAt(0)) || set.contains(cur)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            set.add(cur);
        }

        return answer;
    }
}