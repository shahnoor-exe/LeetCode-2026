class Solution {
    public int minAddToMakeValid(String s) {
        int x=0,y=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') x++;
            else if(x>0) x--;
            else y++;
        }return x+y;
    }
}