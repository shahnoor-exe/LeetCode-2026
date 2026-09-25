class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> q=new LinkedList<>();
        Set<String> res=new TreeSet<>();
        Set<String> vis=new HashSet<>();
        q.offer(expression);
        vis.add(expression);
        while(!q.isEmpty()){
            String s=q.poll();
            if(s.indexOf('{')==-1){
                res.add(s);
                continue;
            }int r=s.indexOf('}');
            int l=s.lastIndexOf('{',r);
            String b=s.substring(0,l);
            String a=s.substring(r+1);
            String[] p=s.substring(l+1,r).split(",");
            for(String x:p){
                String nxt=b+x+a;
                if(vis.add(nxt)){
                    q.offer(nxt);
                }
            }
        }return new ArrayList<>(res);
    }
}