class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        Set<Integer> s= new HashSet<>();
        for(int n:nums){
            min=Math.min(n,min);
            max=Math.max(n,max);
            s.add(n);
        }
        List<Integer> r=new ArrayList<>();
        for(int i=min+1;i<max;i++){
            if(!s.contains(i)) r.add(i);
        }return r;
    }
}