class Solution {
    public boolean uniformArray(int[] nums1) {
        int mo=Integer.MAX_VALUE;
        int me=Integer.MAX_VALUE;
        for(int n:nums1){
            if(n%2!=0){
                if(n<mo) mo=n;
            }else{
                if(n<me) me=n;
            }
        }if(mo==Integer.MAX_VALUE) return true;
        return mo<me;
    }
}