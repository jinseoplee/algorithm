class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        
        for (int e : arr) {
            sum += e;    
        }
        
        return 1.0 * sum / arr.length;
    }
}