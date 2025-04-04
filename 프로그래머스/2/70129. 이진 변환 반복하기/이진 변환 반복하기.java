class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0}; // [변환 횟수, 제거된 0의 개수]
        
        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replace("0", "");
            answer[1] += beforeLength - s.length();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        
        return answer;
    }
}