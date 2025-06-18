import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int k = 0; k < arr.length; k++) {
                char c = arr[(i + k) % arr.length];

                if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } 
            
            if (stack.isEmpty() && flag) {
                count++;
            }
        }
        
        return count;
    }
}