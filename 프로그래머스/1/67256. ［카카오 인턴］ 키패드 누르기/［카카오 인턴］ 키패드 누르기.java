/**
* 제한 사항
* 1 <= numbers <= 1,000
* 0 <= numbers의 원소 <= 9
*
* 시간 복잡도
* O(numbers.length)
**/
class Solution {
    
    int[][] numPos = {
        {3, 1}, // 0
        {0, 0}, // 1
        {0, 1}, // 2
        {0, 2}, // 3
        {1, 0}, // 4
        {1, 1}, // 5
        {1, 2}, // 6
        {2, 0}, // 7
        {2, 1}, // 8
        {2, 2}, // 9
    };
    
    int[] leftPos = {3, 0}; // 왼손 엄지손가락 위치
    int[] rightPos = {3, 2}; // 오른손 엄지손가락 위치
    
    public String solution(int[] numbers, String hand) {
        hand = hand.equals("left") ? "L" : "R";
        
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            String result = pushNumber(num, hand);
            
            if (result.equals("L")) leftPos = numPos[num];
            if (result.equals("R")) rightPos = numPos[num];
            
            sb.append(result);
        }
        return sb.toString();
    }
    
    String pushNumber(int num, String hand) {
        if (num == 1 || num == 4 || num == 7) return "L";
        if (num == 3 || num == 6 || num == 9) return "R";
        
        // 2, 5, 8, 0
        int lDist = getDist(leftPos, num);
        int rDist = getDist(rightPos, num);
        
        if (lDist > rDist) return "R";
        if (lDist < rDist) return "L";
        return hand;
    }
    
    int getDist(int[] pos, int num) {
        return Math.abs(pos[0] - numPos[num][0]) + Math.abs(pos[1] - numPos[num][1]);
    }
}