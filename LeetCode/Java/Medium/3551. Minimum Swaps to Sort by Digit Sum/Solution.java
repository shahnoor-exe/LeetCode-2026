class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length, ans=0;
        Integer[] p=new Integer[n];
        for(int i=0;i<n;i++) p[i]=i;
        Arrays.sort(p,(a,b)->{
            int sa=0,sb=0,x=nums[a],y=nums[b];
            while(x>0) {sa+=x%10;x/=10;}
            while(y>0) {sb+=y%10;y/=10;}
            return sa!=sb?Integer.compare(sa,sb):Integer.compare(nums[a],nums[b]);
        });
        boolean[] v=new boolean[n];
        for(int i=0;i<n;i++){
            if(v[i] || p[i]==i) continue;
            int j=i,c=0;
            while(!v[j]){
                v[j]=true;
                j=p[j];
                c++;
            }ans+=c-1;
        }return ans;
    }
}