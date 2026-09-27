class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] p = new int[n];
        int[] st = new int[n];
        int t = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st[t++] = i;
            } else if (s.charAt(i) == ')') {
                int j = st[--t];
                p[i] = j;
                p[j] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0, d = 1;
        
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = p[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
            i += d;
        }
        
        return sb.toString();
    }
}