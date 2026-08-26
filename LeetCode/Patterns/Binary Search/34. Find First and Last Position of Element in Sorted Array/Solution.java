class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r=nums.length-1; int f=-1, e=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target) {f=m; r=m-1;}
            else if(target>nums[m]) l=m+1;
            else r=m-1;
        } if(f==-1) return new int[] {-1,-1};
        l=0; r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(target==nums[m]) {e=m;l=m+1;}
            else if(target>nums[m]) l=m+1;
            else r=m-1;
        } return new int[] {f,e};

    }
}