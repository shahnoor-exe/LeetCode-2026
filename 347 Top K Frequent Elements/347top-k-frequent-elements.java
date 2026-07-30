class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int n: nums){
            m.put(n, m.getOrDefault(n,0)+1);
        }
        List<Integer>[] bucket= new List[nums.length+1];
        for(int i:m.keySet()){
            int x=m.get(i);
            if(bucket[x]==null){
                bucket[x]=new ArrayList<>();
            }bucket[x].add(i);
        }
        int[] y=new int[k];
        int c=0;
        for(int i=bucket.length-1;i>=0&&c<k;i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    y[c++]=n;
                    if(c==k) break;
                }
            }
        }return y;
    }
}