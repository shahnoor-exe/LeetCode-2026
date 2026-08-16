class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] n=new int[3];
        for(int x:stones) {
            n[x%3]++;
        }int n1=n[0],n2=n[1],n3=n[2];
        if(n1%2==0) return n2>=1 && n3>=1;
        return Math.abs(n2-n3)>2;
    }
}