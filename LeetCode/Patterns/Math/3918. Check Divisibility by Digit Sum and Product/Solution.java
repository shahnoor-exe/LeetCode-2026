class Solution {
    public boolean checkDivisibility(int n) {
        int x=n,y=0,z=1;
        while(x>0){
            int a=x%10;
            y+=a;
            z*=a;
            x/=10;
        }
        int s=y+z;
        return n%s==0;
    }
}