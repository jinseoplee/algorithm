class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // (m x n) 행렬과 (n x k) 행렬의 곱은 (m x k)
        int m = arr1.length;
        int n = arr1[0].length;
        int k = arr2[0].length;
        
        int[][] answer = new int[m][k];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    answer[i][j] += arr1[i][l] * arr2[l][j];
                }
            }
        }
        
        return answer;
    }
}