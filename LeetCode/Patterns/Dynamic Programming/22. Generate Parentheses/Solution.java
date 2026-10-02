class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r=new ArrayList<>();
        bt(r,new char[n*2],0,0,0,n);
        return r;
    }private void bt(List<String> r,char[] a,int i,int o,int c,int n) {
        if(i==n*2){
            r.add(new String(a));
            return;
        }if(o<n){
            a[i]='(';
            bt(r,a,i+1,o+1,c,n);
        }if(c<o){
            a[i]=')';
            bt(r,a,i+1,o,c+1,n);
        }
    }
}