class Solution {
    public String solution(String[] seoul) {
        int x = 0;
        
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                x = i;
                break;
            }
        }
        
        return "김서방은 " + x + "에 있다";
    }
}