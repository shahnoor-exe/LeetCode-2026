class Solution {
    public int maxProduct(int n) {
        int i=0, j=0;
        while(n>0){
            int x=n%10;
            if(x>i){
                j=i;
                i=x;
            }else if(x>j) j=x;
            n/=10;
        }return i*j;
    }
}