class Solution {
    public int sumCounts(List<Integer> nums) {
        int a=0,n=nums.size();
        for(int i=0;i<n;i++){
            boolean[] s=new boolean[101];
            for(int j=i,c=0;j<n;j++){
                if(!s[nums.get(j)]) {s[nums.get(j)]=true; c++;}
                a+=c*c;
            }
        }return a;
    }
}