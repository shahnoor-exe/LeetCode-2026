class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0, max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min]) min=i;
            if(nums[i]>nums[max]) max=i;
        }int l=Math.min(min,max);
        int r=Math.max(min,max);
        int x=r+1;
        int y=nums.length-l;
        int z=(l+1)+(nums.length-r);
        return Math.min(x,Math.min(y,z));
    }
}