/**
* 제한 사항
* 2 <= n <= 100
* 1 <= w <= 10
* 1 <= num <= n
*
* 시간 복잡도
* O(h * w + h)
*/
class Solution {
    public int solution(int n, int w, int num) {
        int h = (n + w - 1) / w;
        int[][] arr = new int[h][w];
        
        int boxNum = 1;
        int targetRow = -1, targetCol = -1;
        
        for (int i = 0; i < h; i++) {
            // 짝수일 때 왼쪽에서 오른쪽 방향으로 저장
            if (i % 2 == 0) {
                for (int j = 0; j < w && boxNum <= n; j++) {
                    arr[i][j] = boxNum++;
                    if (arr[i][j] == num) {
                        targetRow = i;
                        targetCol = j;
                    }
                }
            }
            
            // 홀수일 때 오른쪽에서 왼쪽 방향으로 저장
            else {
                for (int j = w - 1; j >= 0 && boxNum <= n; j--) {
                    arr[i][j] = boxNum++;
                    if (arr[i][j] == num) {
                        targetRow = i;
                        targetCol = j;
                    }
                }            
            }
        }
        
        // 꺼내야 하는 상자의 총개수를 구한다
        int totalCount = 0;
        for (int i = h - 1; i >= targetRow; i--) {
            if (arr[i][targetCol] != 0) {
                totalCount++;
            }
        }
        return totalCount;
    }
}