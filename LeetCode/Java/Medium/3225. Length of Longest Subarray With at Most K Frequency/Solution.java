class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> n=new HashMap<>();
        int x=0,l=0;
        for(int r=0;r<nums.length;r++){
            n.put(nums[r],n.getOrDefault(nums[r],0)+1);
            while(n.get(nums[r])>k){
                n.put(nums[l],n.put(nums[l],0)-1);
                l++;
            }x=Math.max(x,r-l+1);
        }return x;
    }
}