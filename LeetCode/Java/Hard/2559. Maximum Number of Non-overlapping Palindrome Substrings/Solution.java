class Solution {
    public int maxPalindromes(String s, int k) {
        int c=0;
        int st=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(i-k+1>=st && isPalindrome(s,i-k+1,i)){
                c++;
                st=i+1;
                continue;
            }if(i-k>=st && isPalindrome(s,i-k,i)){
                c++;
                st=i+1;
            }
        }return c;
    }private boolean isPalindrome(String s, int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }return true;
    }
}