class Solution {
    public int[] solution(int[] num_list) {
        int s = 0;
        int e = num_list.length - 1;
        
        while (s < e) {
            int temp = num_list[s];
            num_list[s] = num_list[e];
            num_list[e] = temp;
            s++;
            e--;
        }
        
        return num_list;
    }
}