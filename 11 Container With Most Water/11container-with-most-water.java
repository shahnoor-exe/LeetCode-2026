class Solution {
    public int maxArea(int[] height) {
        int a=0;
        int l=0,r=height.length-1;
        while(l<r)
        {
            int ca=0;
            if(height[l]<height[r])
            {
                ca=(r-l)*height[l];
                l++;
            }
            else{
                ca=(r-l)*height[r];
                r--;
            }
            a=Math.max(a,ca);
        }
        return a;
    }
}