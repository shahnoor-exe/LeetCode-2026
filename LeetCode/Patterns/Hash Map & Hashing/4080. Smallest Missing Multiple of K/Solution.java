class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] x=new boolean[101];
        for(int n:nums) x[n]=true;
        int y=k;
        while(y<=100 && x[y]) y+=k;
        return y;
    }
}