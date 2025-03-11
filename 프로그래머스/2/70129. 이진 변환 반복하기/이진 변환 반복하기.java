class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        // s가 1이 될 때까지 반복
        while (!s.equals("1")) {
            // 1. 모든 0을 제거
            String removed = s.replace("0", "");
            
            // 제거된 0의 개수 카운트
            answer[1] += s.length() - removed.length();
            
            // 2. removed의 길이를 2진법으로 표현
            s = Integer.toBinaryString(removed.length());
            
            // 이진 변환 횟수 증가
            answer[0]++;
        }
        
        return answer;
    }
}