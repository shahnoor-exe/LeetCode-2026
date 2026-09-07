class Solution {
    public int distinctSubseqII(String s) {
        int x=1_000_000_007;
        int[] y=new int [26];
        int z=0;
        for(char c:s.toCharArray()){
            int i=c-'a';
            int p=y[i];
            int q=z+1;
            if(q>=x) q-=x;
            y[i]=q;
            z-=p;
            if(z<0) z+=x;
            z+=q;
            if(z>=x) z-=x;
        }return z;
    }
}