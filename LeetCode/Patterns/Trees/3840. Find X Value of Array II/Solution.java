class Solution {
    int[] tp,tc;
    int rp,ans,K;
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n=nums.length;
        this.K=k;
        tp=new int[4*n];
        tc=new int[4*n*k*k];
        b(1,0,n-1,nums);
        int m=queries.length;
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            u(1,0,n-1,queries[i][0],queries[i][1]);
            rp=1%K;
            ans=0;
            q(1,0,n-1,queries[i][2],n-1,queries[i][3]);
            res[i]=ans;
        }return res;
    }private void b(int nd,int l,int r, int[] a){
        if(l==r){
            int v=a[l]%K;
            tp[nd]=v;
            for(int j=0;j<K;j++)tc[nd*K*K+j*K+(j*v)%K]=1;
            return;
        }int md=l+(r-l)/2;
        b(2*nd,l,md,a);
        b(2*nd+1,md+1,r,a);
        m(nd);
    }private void u(int nd,int l,int r,int idx,int val){
        if(l==r){
            int v=val%K;
            tp[nd]=v;
            int base=nd*K*K;
            for(int i=0;i<K*K;i++) tc[base+i]=0;
            for(int j=0;j<K;j++) tc[base+j*K+(j*v)%K]=1;
            return;
        }int md=l+(r-l)/2;
        if(idx<=md) u(2*nd,l,md,idx,val);
        else u(2*nd+1,md+1,r,idx,val);
        m(nd);
    }private void m(int nd) {
        int lc=2*nd,rc=2*nd+1;
        tp[nd]=(tp[lc]*tp[rc])%K;
        int bn=nd*K*K,bl=lc*K*K,br=rc*K*K;
        for (int j=0;j<K;j++){
            int nj=(j*tp[lc])%K;
            int ol=bl+j*K,or=br+nj*K,on=bn+j*K;
            for(int x=0;x<K;x++) tc[on+x]=tc[ol+x]+tc[or+x];
        }
    }private void q(int nd, int l, int r, int ql, int qr, int x) {
        if(ql<=l&&r<=qr){
            ans+=tc[nd*K*K+rp*K+x];
            rp=(rp*tp[nd])%K;
            return;
        }int md=l+(r-l)/2;
        if(ql<=md) q(2*nd,l,md,ql,qr,x);
        if(qr>md)q(2*nd+1,md+1,r,ql,qr,x);
    }
}