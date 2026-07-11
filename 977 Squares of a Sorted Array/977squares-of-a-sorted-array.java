class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] result= new int[n];
        int l=0;
        int r=n-1;
        for(int i=n-1;i>=0;i--) {
            int ls=nums[l]*nums[l];
            int rs=nums[r]*nums[r];
            if(ls>rs){
                result[i]=ls;
                l++;
            } else {
                result[i]=rs;
                r--;
            }        
        }
        return result;
    }
}