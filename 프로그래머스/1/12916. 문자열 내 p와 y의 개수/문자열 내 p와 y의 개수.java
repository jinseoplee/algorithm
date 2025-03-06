class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') pCnt++;
            if (c == 'y') yCnt++;
        }
        
        return pCnt == yCnt;
    }
}