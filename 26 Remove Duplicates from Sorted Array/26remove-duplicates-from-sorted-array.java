class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
    int c=1;int i=0;
    while(i<nums.length-1) {
        if(nums[i]!=nums[i+1]) {
            nums[c]=nums[i+1];
            c++;
        }i++;
    } return c;
    }
}