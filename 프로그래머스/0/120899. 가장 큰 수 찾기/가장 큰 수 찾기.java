class Solution {
    public int[] solution(int[] array) {
        int maxIdx = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }
        }
        
        return new int[] { array[maxIdx], maxIdx };
    }
}