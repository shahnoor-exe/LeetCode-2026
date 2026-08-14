class Solution {
    public int maximumLengthSubstring(String s) {
        int[] x=new int[26];
        int l=0,y=0;
        for(int r=0;r<s.length();r++){
            int c2=s.charAt(r)-'a';
            x[c2]++;
            while(x[c2]>2){
                int c1=s.charAt(l)-'a';
                x[c1]--;
                l++;
            }y=Math.max(y,r-l+1);
        }return y;
    }
}