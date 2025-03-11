class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        boolean done = false;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                done = false;
            } else {
                if (done) {
                    arr[i] = Character.toLowerCase(arr[i]);
                } else {
                    arr[i] = Character.toUpperCase(arr[i]);
                    done = true;
                }
            }
        }
        
        return new String(arr);
    }
}