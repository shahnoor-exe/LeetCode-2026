class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray())
            if (c == '(') l++;
            else if (c == ')') 
                if (l > 0) l--; else r++;
                
        Set<String> ans = new HashSet<>();
        dfs(s, 0, l, r, 0, new StringBuilder(), ans);
        return new ArrayList<>(ans);
    }
    private void dfs(String s, int i, int l, int r, int o, StringBuilder sb, Set<String> ans) {
        if (i == s.length()) {
            if (l == 0 && r == 0 && o == 0) ans.add(sb.toString());
            return;
        }
        
        char c = s.charAt(i);
        int len = sb.length();
        
        if (c == '(' && l > 0) dfs(s, i + 1, l - 1, r, o, sb, ans);
        if (c == ')' && r > 0) dfs(s, i + 1, l, r - 1, o, sb, ans);
        
        sb.append(c);
        if (c != '(' && c != ')') dfs(s, i + 1, l, r, o, sb, ans);
        else if (c == '(') dfs(s, i + 1, l, r, o + 1, sb, ans);
        else if (c == ')' && o > 0) dfs(s, i + 1, l, r, o - 1, sb, ans);
        
        sb.setLength(len);
    }
}