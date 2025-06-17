class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        for (char c : s.toLowerCase().toCharArray()) {
            sb.append(flag ? Character.toUpperCase(c) : c);
            flag = (c == ' ');
        }
        
        return sb.toString();
    }
}