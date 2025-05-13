import java.util.*;

class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 가로
        int m = sc.nextInt(); // 세로

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}