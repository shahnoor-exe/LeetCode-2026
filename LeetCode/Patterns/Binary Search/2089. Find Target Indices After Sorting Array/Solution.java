class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int l=0,c=0;
        for(int n:nums)
        if(n<target) l++;
        else if(n==target) c++;
        List<Integer> x=new ArrayList<>();
        for(int i=0;i<c;i++) x.add(l++);
        return x;
    }
}