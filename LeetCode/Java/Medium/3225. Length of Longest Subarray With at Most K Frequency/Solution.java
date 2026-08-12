class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int y=nums.length;
        HashMap<Integer,Integer> n=new HashMap<>();
        int x=0,l=0;
        for(int r=0;r<y;r++){
            n.put(nums[r],n.getOrDefault(nums[r],0)+1);
            while(n.get(nums[r])>k){
                n.put(nums[l],n.get(nums[l])-1);
                l++;
            }x=Math.max(x,r-l+1);
        }return x;
    }
}