class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int cs=0;
        for(int i=0;i<k;i++){
            cs+=nums[i];
        }
        int s=cs;
        for(int i=k;i<nums.length;i++){
            cs=cs+nums[i]-nums[i-k];
            s=Math.max(cs,s);
         } return (double) s/k;
    }
}