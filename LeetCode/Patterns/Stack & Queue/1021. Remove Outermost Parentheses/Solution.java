class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder s1=new StringBuilder();
        int d=0;
        for(char c:s.toCharArray()){
            if(c=='(' && d++>0) s1.append(c);
            if(c==')' && --d>0) s1.append(c);
        }return s1.toString();
    }
}