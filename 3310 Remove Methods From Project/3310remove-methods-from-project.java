class Solution {
    private void dfs(int node, List<Integer>[] l, boolean[] s) {
        s[node] = true;
        for (int x:l[node]) {
            if (!s[x]) dfs(x,l,s);
        }
    } public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] l=new ArrayList[n];
        for(int i=0;i<n;i++) l[i] = new ArrayList<>();
        for(int[] j:invocations) l[j[0]].add(j[1]);
        boolean[] s=new boolean[n];
        dfs(k,l,s);
        for(int[] j:invocations) {
            if(!s[j[0]] && s[j[1]]) {
                List<Integer> l2=new ArrayList<>();
                for(int i=0;i<n;i++) l2.add(i);
                return l2;
            }
        }List<Integer> r = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(!s[i]) r.add(i);
        }return r;
    }
}