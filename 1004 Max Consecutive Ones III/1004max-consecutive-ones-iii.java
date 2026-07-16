class Solution {
    public int longestOnes(int[] nums, int k) {
        int c=0; int l=0; int ml=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0) c++;
            while(c>k){
                if(nums[l]==0){
                    c--;
                }l++;
            }int cl=r-l+1;
            ml=Math.max(cl,ml);
        }return ml;
    }
}