class Solution {
    public int minOperations(String s) {
        int n=s.length(),mn='z',mx= 'a',cMn=0,cMx=0;
        boolean ok=true;
        for(int i=0;i<n;i++) {
            char c=s.charAt(i);
            if(i>0 && c<s.charAt(i-1)) ok=false;
            if(c<mn) {mn=c; cMn=1;} else if(c==mn) cMn++;
            if(c>mx) {mx=c; cMx=1;} else if(c==mx) cMx++;
        }if(ok) return 0;
        if(n==2) return -1;
        if(s.charAt(0)==mn || s.charAt(n-1)==mx) return 1;
        if(s.charAt(0)==mx && s.charAt(n-1)==mn && cMn==1 && cMx==1) return 3;
        return 2;
    }
}