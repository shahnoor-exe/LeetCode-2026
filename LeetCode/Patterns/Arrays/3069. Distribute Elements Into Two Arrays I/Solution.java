class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> x=new ArrayList<>();
        List<Integer> y=new ArrayList<>();
        x.add(nums[0]);
        y.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            int x1=x.get(x.size()-1);
            int y1=y.get(y.size()-1);
            if(x1>y1) x.add(nums[i]);
            else y.add(nums[i]);
        }
        int[] z=new int[nums.length];
        int i=0;
        for(int e:x) z[i++]=e;
        for(int e:y) z[i++]=e;
        return z;
    }
}