class Solution {
    public int minInsertions(String s) {
        int x=0,y=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                if(y%2!=0) {x++;y--;}
                y+=2;
            }else if(--y<0) {x++;y+=2;}
        }return x+y;
    }
}