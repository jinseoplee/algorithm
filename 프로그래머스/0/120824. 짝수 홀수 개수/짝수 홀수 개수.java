class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = {0, 0}; // 짝수와 홀수 개수
        
        for (int num : num_list) {
            arr[num % 2]++;
        }
        
        return arr;
    }
}