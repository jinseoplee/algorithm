import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int top = -1;
        int i = 0;
        
        while (i < arr.length) {
            if (top == -1 || stk[top] < arr[i]) {
                stk[++top] = arr[i++];
            } else {
                top--;
            }
        }
        
        return Arrays.copyOf(stk, top + 1);
    }
}