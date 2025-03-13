import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < arr.length; j++) {
                char c = arr[(i + j) % arr.length];
                if (stack.isEmpty() || c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else {
                    if ((stack.peek() == '[' && c == ']') ||
                        (stack.peek() == '{' && c == '}') ||
                        (stack.peek() == '(' && c == ')')) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}