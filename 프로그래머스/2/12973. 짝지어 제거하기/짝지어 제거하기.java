import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 스택이 비어있거나 스택의 top과 현재 문자가 다른 경우
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                // 스택의 top과 현재 문자가 같으면 짝을 이루므로 제거
                stack.pop();
            }
        }
        
        // 스택이 비어있으면 모든 짝을 제거한 것이므로 1을 반환
        // 스택에 문자가 남아있으면 짝지어 제거할 수 없는 문자들이 있으므로 0을 반환
        return stack.isEmpty() ? 1 : 0;
    }
}