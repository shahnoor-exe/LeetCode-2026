class Solution {
    public int countCommas(int n) {
        int c=0;
        long x=1000;
        while(n>=x){
            c+=(n-x+1);
            x*=1000;
        }return c;
    }
}