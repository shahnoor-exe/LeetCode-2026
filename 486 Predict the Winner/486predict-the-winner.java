class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[] n= new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            n[i]=nums[i];
        }for (int i=nums.length-2;i>=0;i--) {
            for (int j=i+1;j<nums.length;j++) {
                n[j]=Math.max(nums[i]-n[j],nums[j]-n[j - 1]);
            }
        }return n[nums.length-1] >= 0;
    }
}