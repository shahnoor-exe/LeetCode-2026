class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int currentDepth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                currentDepth++;
                max = Math.max(max, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }
        
        return max;
    }
}