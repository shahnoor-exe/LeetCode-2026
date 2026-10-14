class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>num*9) return "";
        char[] x=new char[num];
        for(int i=0;i<num;i++){
            int y=Math.min(9,sum);
            x[i]=(char) (y+'0');
            sum-=y;
        }return new String(x);
    }
}