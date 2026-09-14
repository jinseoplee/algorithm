class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        String op = ineq + eq;
        boolean result = false;
        
        if (">=".equals(op)) {
            result = n >= m;
        } else if ("<=".equals(op)) {
            result = n <= m;
        } else if (">!".equals(op)) {
            result = n > m;
        } else {
            result = n < m;
        }
        
        return result ? 1 : 0;
    }
}