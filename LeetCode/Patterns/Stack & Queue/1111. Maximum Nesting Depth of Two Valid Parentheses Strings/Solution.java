class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] r=new int[n];
        int d=0;
        for(int i=0;i<n;i++) r[i]=seq.charAt(i)=='('?++d%2:d--%2;
        return r;
    }
}