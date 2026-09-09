class Solution {
    public long countCommas(long n) {
       long c=0;
       long x=1000;
       while(n>=x){
        c+=(n-x+1);
        x*=1000;
       } return c;
    }
}