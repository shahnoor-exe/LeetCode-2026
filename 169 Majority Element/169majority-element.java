class Solution {
    public int majorityElement(int[] nums) {
        int ca=0, c=0;
        for(int n:nums){
            if(c==0) ca=n;
            c+=(n==ca)?1:-1;
        }return ca;
    }
}