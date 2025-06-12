import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        
        // 대문자는 소문자로, 소문자는 대문자로
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ans += Character.toLowerCase(c);
            } else {
                ans += Character.toUpperCase(c);
            }
        }
        
        System.out.println(ans);
    }
}