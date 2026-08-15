class Solution {
    public int longestSubsequence(int[] nums) {
        int s=0;
        boolean x=false;
        for(int n:nums){
            s^=n;
            if(n!=0) x=true;
        }if(s!=0) return nums.length;
        return x?nums.length-1:0;
    }
}