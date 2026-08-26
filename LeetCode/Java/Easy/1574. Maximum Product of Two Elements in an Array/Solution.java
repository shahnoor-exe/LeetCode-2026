class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length<2) return -1;
        int i=0, j=0;
        for(int n:nums){
            if(n>i){
                j=i;
                i=n;
            } else if(n>j) j=n;
        } return (i-1)*(j-1);
    }
}