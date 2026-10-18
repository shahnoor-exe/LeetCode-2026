class Solution {
    long[][] c;
    long mod=1000000007;
    public int numOfWays(int[] nums) {
      int n=nums.length;
        c=new long[n][n];
        for(int i=0;i<n;i++){
            c[i][0]=c[i][i]=1;
            for(int j= 1;j<i;j++) c[i][j]=(c[i-1][j-1]+c[i-1][j])%mod;
        }List<Integer> list=new ArrayList<>();
        for(int x:nums) list.add(x);
        return (int)((dfs(list)-1+mod)%mod);
    }private long dfs(List<Integer> nums){
        if(nums.size()<=2) return 1;
        int root=nums.get(0);
        List<Integer> l=new ArrayList<>(),r=new ArrayList<>();
        for(int i=1;i<nums.size();i++)
            if(nums.get(i)<root) l.add(nums.get(i));else r.add(nums.get(i));
        return c[l.size()+r.size()][l.size()]*dfs(l)%mod*dfs(r)%mod;
    }
}