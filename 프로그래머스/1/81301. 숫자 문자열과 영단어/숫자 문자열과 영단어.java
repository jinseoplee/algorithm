import java.util.*;

/**
* 1 <= s의 길이 <= 50
* 1 <= 리턴 값 <= 2,000,000,000
*
* 구현 = O(n)
*/
class Solution {
    
    public int solution(String s) {
        Map<String, String> words = createWords();
        
        String answer = "";
        String word = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                answer += c;
            } else {
                word += c;
                if (words.containsKey(word)) {
                    answer += words.get(word);
                    word = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    Map<String, String> createWords() {
        Map<String, String> words = new HashMap<>();
        words.put("zero", "0");
        words.put("one", "1");
        words.put("two", "2");
        words.put("three", "3");
        words.put("four", "4");
        words.put("five", "5");
        words.put("six", "6");
        words.put("seven", "7");
        words.put("eight", "8");
        words.put("nine", "9");
        return words;
    }
}