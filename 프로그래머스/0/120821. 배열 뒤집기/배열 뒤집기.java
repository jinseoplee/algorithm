class Solution {
    public int[] solution(int[] num_list) {
        int i = 0;
        int j = num_list.length - 1;
        
        while (i < j) {
            int temp = num_list[i];
            num_list[i] = num_list[j];
            num_list[j] = temp;
            i++;
            j--;
        }
        
        return num_list;
    }
}